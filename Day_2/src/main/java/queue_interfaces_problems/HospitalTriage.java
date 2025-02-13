package queue_interfaces_problems;

import java.util.*;

// Class representing a patient
class Patient {
    String name;
    int severity;

    // Constructor to initialize patient details
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

}

// Custom comparator to sort patients by severity (higher severity = higher
// priority)
class SeverityComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity); // Sort in descending order
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // PriorityQueue that uses SeverityComparator for sorting
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new SeverityComparator());

        // Adding patients to the queue
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Process patients based on priority (higher severity first)
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll().name); // Remove and print the highest-priority patient
        }
    }
}