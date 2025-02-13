package implement_banking_system;

import java.util.*;

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    // Add a new account
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber); // Update new balance
            System.out.println("Deposited $" + amount + " into account: " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Request a withdrawal (added to queue)
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for account: " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                double newBalance = accounts.get(accountNumber) - amount;
                sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber); // Update new balance
                System.out.println("Withdrawn $" + amount + " from account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance or account not found for: " + accountNumber);
            }
        }
    }

    // View accounts sorted by balance
    public void viewAccountsByBalance() {
        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, String> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " | Balance: $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount("A1001", 5000);
        bank.addAccount("A1002", 2000);
        bank.addAccount("A1003", 7000);

        // Depositing money
        bank.deposit("A1002", 3000);

        // Requesting withdrawals
        bank.requestWithdrawal("A1001");
        bank.requestWithdrawal("A1003");

        // Processing withdrawals
        bank.processWithdrawals(1000);

        // Viewing accounts sorted by balance
        bank.viewAccountsByBalance();
    }
}
