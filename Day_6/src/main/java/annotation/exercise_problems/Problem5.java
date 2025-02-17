package annotation.exercise_problems;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "UI bug")
    @BugReport(description = "Performance issue")
    void trackBugs() {
        System.out.println("Tracking bugs...");
    }
}

public class Problem5 {
    public static void main(String[] args) throws NoSuchMethodException {
        BugReport[] reports = BugTracker.class.getMethod("trackBugs").getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}