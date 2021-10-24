package bankaccountchallenge;

import java.util.concurrent.locks.ReentrantLock;

public class Challenge1 {
    // Challenge 1: Create and start two threads that use the same BankAccount instance and an initial balance of $1000.
    // One will deposit $300, and then withdraw $50.
    // The other will deposit $203.75, and then withdraw $100

    // The other challenges involve changes to the BankAccount class

    public static void main(String[] args) {
        BankAccount account = new BankAccount( 1000, "12345-678");

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
                System.out.println(account);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
                System.out.println(account);
            }
        }).start();
    }
}
