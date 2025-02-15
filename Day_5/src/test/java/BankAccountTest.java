import static org.junit.jupiter.api.Assertions.*;

import advanced_junit_problems.BankAccount;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }
}