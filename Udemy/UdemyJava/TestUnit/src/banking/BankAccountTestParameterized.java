package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

// parameterized tests are tests where you provide a full range of expected and results in a structure
// and then it runs a single test for each input, thus avoiding repeating lots of code

// this is particularly done on JUnit 4 - example of JUnit 5 parameterized test can be found in the challenge package
@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }

    @org.junit.Test // junit4
    public void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
