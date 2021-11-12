package bankingchallenge;

import java.util.ArrayList;

public class Customer {
    private String name;
    private final ArrayList<Double> transactions;

    public Customer(String name, double initialTransactionValue) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(Double.valueOf(initialTransactionValue)); // autoboxing done on purpose here, could be just initialTransactionValue
    }

    public static Customer newCustomer(String name, double initialTransactionValue) {
        return new Customer(name, initialTransactionValue);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void addTransaction(double transactionValue) {
        this.transactions.add(transactionValue);
    }
}
