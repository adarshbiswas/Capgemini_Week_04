// Problem 3: Multi-Level University Course Management System
package multilevel_uni_management_system;

import java.util.*;
import static multilevel_uni_management_system.Course.displayCourses;

// Abstract class representing a course type
abstract class CourseType {
    String name;
    public CourseType(String name) { this.name = name; }
    public String getName() { return name; }
}

// Different course types
class ExamCourse extends CourseType {
    public ExamCourse(String name) { super(name); }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) { super(name); }
}

// Generic course management system
class Course<T extends CourseType> {
    List<T> courses = new ArrayList<>();
    public void addCourse(T course) { courses.add(course); }
    // Displays all courses
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getName());
        }
    }
}
public class MultiLevelUniManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>();
        examCourse.addCourse(new ExamCourse("Mathematics"));
        displayCourses(((Course<ExamCourse>) examCourse).courses);
    }
}
