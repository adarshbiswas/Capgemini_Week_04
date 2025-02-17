package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AdminTask {
    @RoleAllowed("ADMIN")
    void performAdminTask() {
        System.out.println("Admin task executed");
    }
}

public class Problem5 {
    public static void main(String[] args) throws NoSuchMethodException {
        String userRole = "USER"; // Simulate user role
        RoleAllowed role = AdminTask.class.getMethod("performAdminTask").getAnnotation(RoleAllowed.class);
        if (!role.value().equals(userRole)) {
            System.out.println("Access Denied!");
        } else {
            new AdminTask().performAdminTask();
        }
    }
}