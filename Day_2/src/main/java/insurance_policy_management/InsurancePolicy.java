package insurance_policy_management;

import java.time.LocalDate;
import java.util.*;

class InsurancePol {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;

    public InsurancePol(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate;
    }
}

public class InsurancePolicy {
    private final Map<String, InsurancePol> policyMap = new HashMap<>();
    private final Map<String, InsurancePol> orderedPolicies = new LinkedHashMap<>();
    private final TreeMap<LocalDate, InsurancePol> expirySortedPolicies = new TreeMap<>();

    public void addPolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        InsurancePol policy = new InsurancePol(policyNumber, policyholderName, expiryDate);
        policyMap.put(policyNumber, policy);
        orderedPolicies.put(policyNumber, policy);
        expirySortedPolicies.put(expiryDate, policy);
    }

    public InsurancePol getPolicyByNumber(String policyNumber) {
        return policyMap.getOrDefault(policyNumber, null);
    }

    public List<InsurancePol> getPoliciesExpiringInNext30Days() {
        List<InsurancePol> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        for (Map.Entry<LocalDate, InsurancePol> entry : expirySortedPolicies.entrySet()) {
            if (entry.getKey().isAfter(today) && entry.getKey().isBefore(thresholdDate)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePol> getPoliciesByHolder(String holderName) {
        List<InsurancePol> policies = new ArrayList<>();
        for (InsurancePol policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePol>> iterator = expirySortedPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePol> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                String policyNumber = entry.getValue().policyNumber;
                policyMap.remove(policyNumber);
                orderedPolicies.remove(policyNumber);
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicy system = new InsurancePolicy();

        // Adding policies
        system.addPolicy("P123", "John Doe", LocalDate.now().plusDays(10));
        system.addPolicy("P456", "Alice Smith", LocalDate.now().plusDays(40));
        system.addPolicy("P789", "Bob Johnson", LocalDate.now().minusDays(5)); // Expired

        // Retrieve a policy by number
        System.out.println("Retrieve Policy P123: " + system.getPolicyByNumber("P123"));

        // List policies expiring in next 30 days
        System.out.println("Policies expiring in next 30 days: " + system.getPoliciesExpiringInNext30Days());

        // List policies for a specific holder
        System.out.println("Policies for John Doe: " + system.getPoliciesByHolder("John Doe"));

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + system.policyMap.values());
    }
}
