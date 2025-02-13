package policy_management;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Policy class representing an insurance policy
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor to initialize Policy attributes
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
            double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters for required attributes
    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    // Overriding equals() and hashCode() to ensure unique policies based on
    // policyNumber
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Compare policies by expiry date for TreeSet sorting
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // Override toString() for better output readability
    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

// Main class for policy management
public class InsurancePolicyManagement {
    // Using different sets for various storage needs
    private Set<Policy> hashSetPolicies = new HashSet<>(); // Fast lookup
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>(); // Maintains insertion order
    private Set<Policy> treeSetPolicies = new TreeSet<>(); // Sorted by expiry date

    // Method to add a policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public List<Policy> getAllPolicies() {
        return new ArrayList<>(hashSetPolicies);
    }

    // Get policies that are expiring within the next 30 days
    public List<Policy> getExpiringSoon() {
        LocalDate now = LocalDate.now();
        List<Policy> expiringSoon = new ArrayList<>();
        for (Policy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(now, policy.getExpiryDate()) <= 30) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    // Retrieve policies based on their coverage type
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Find duplicate policies based on policy numbers
    public Set<Policy> findDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> seenPolicyNumbers = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) { // If already seen, add to duplicates
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    // Compare performance of HashSet, LinkedHashSet, and TreeSet
    public void performanceComparison() {
        int numPolicies = 100000;
        Random random = new Random();

        // Generate test data for performance evaluation
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 0; i < numPolicies; i++) {
            testPolicies.add(new Policy(
                    "P" + i,
                    "Holder" + i,
                    LocalDate.now().plusDays(random.nextInt(365)), // Random expiry within a year
                    i % 2 == 0 ? "Health" : "Auto", // Alternating coverage type
                    random.nextDouble() * 1000 // Random premium
            ));
        }

        // Measure insertion time for each set type
        long start = System.nanoTime();
        for (Policy policy : testPolicies)
            hashSetPolicies.add(policy);
        long hashSetTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (Policy policy : testPolicies)
            linkedHashSetPolicies.add(policy);
        long linkedHashSetTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (Policy policy : testPolicies)
            treeSetPolicies.add(policy);
        long treeSetTime = System.nanoTime() - start;

        System.out.println("Insertion Time (ns): HashSet=" + hashSetTime + ", LinkedHashSet=" + linkedHashSetTime
                + ", TreeSet=" + treeSetTime);

        // Measure search time for an existing policy
        Policy searchPolicy = testPolicies.get(numPolicies / 2);

        start = System.nanoTime();
        boolean hashSetContains = hashSetPolicies.contains(searchPolicy);
        long hashSetSearchTime = System.nanoTime() - start;

        start = System.nanoTime();
        boolean linkedHashSetContains = linkedHashSetPolicies.contains(searchPolicy);
        long linkedHashSetSearchTime = System.nanoTime() - start;

        start = System.nanoTime();
        boolean treeSetContains = treeSetPolicies.contains(searchPolicy);
        long treeSetSearchTime = System.nanoTime() - start;

        System.out.println("Search Time (ns): HashSet=" + hashSetSearchTime + ", LinkedHashSet="
                + linkedHashSetSearchTime + ", TreeSet=" + treeSetSearchTime);
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        // Adding some sample policies
        manager.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(20), "Health", 500.0));
        manager.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(50), "Auto", 700.0));
        manager.addPolicy(new Policy("P103", "Charlie", LocalDate.now().plusDays(10), "Home", 600.0));
        manager.addPolicy(new Policy("P104", "David", LocalDate.now().plusDays(5), "Health", 800.0));

        // Display all policies
        System.out.println("All Policies: " + manager.getAllPolicies());

        // Get policies expiring soon
        System.out.println("Expiring Soon: " + manager.getExpiringSoon());

        // Get policies by coverage type
        System.out.println("Health Policies: " + manager.getPoliciesByCoverageType("Health"));

        // Check for duplicate policies
        System.out.println("Duplicate Policies: " + manager.findDuplicatePolicies());

        // Compare performance of different sets
        manager.performanceComparison();
    }
}
