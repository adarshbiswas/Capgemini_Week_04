// Problem 5: AI-Driven Resume Screening System
package ai_driven_resume_checker;

import java.util.*;

import static ai_driven_resume_checker.Resume.processResumes;

// Abstract class representing a job role
abstract class JobRole {
    String title;
    public JobRole(String title) { this.title = title; }
    public String getTitle() { return title; }
}

// Different job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() { super("Software Engineer"); }
}
class DataScientist extends JobRole {
    public DataScientist() { super("Data Scientist"); }
}

// Generic resume processing system
class Resume<T extends JobRole> {
    private final T jobRole;
    public Resume(T jobRole) { this.jobRole = jobRole; }
    public T getJobRole() { return jobRole; }
    // Processes resumes for different job roles
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole job : resumes) {
            System.out.println("Processing resume for: " + job.getTitle());
        }
    }
}

public class AIResumeCheckerSystem {
    public static void main(String[] args) {
        List<JobRole> resumes = new ArrayList<>();
        resumes.add(new SoftwareEngineer());
        resumes.add(new DataScientist());
        processResumes(resumes);
    }
}
