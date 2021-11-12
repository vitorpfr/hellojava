package bankaccountchallenge;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private ReentrantLock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    // methods with synchronized keyword
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    public void deposit(double amount) {
        boolean status = false;

        try {
            if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock, deposit aborted...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;

        try {
            if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock, withdraw aborted...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber +
                "'}, currentThread=" + Thread.currentThread().getName();
    }
}
