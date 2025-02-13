package map_interfaces_problems;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;

    // Constructor to initialize Employee object
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name; // Display only the employee name for better readability
    }
}

public class EmployeeGrouping {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        // Group employees by department using Java Streams API
        return employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"));

        // Group employees by department
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Print the grouped employees
        System.out.println(groupedEmployees); // Output: {HR=[Alice, Carol], IT=[Bob]}
    }
}
