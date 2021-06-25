package bankingchallenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int findCustomerInBranch(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public boolean addCustomer(String name, double initialTransactionValue) {
        return addCustomer(Customer.newCustomer(name, initialTransactionValue));
    }

    public boolean addCustomer(Customer customer) {
        if (findCustomerInBranch(customer.getName()) != -1) {
            return false;
        }

        customers.add(customer);
        return true;
    }

    public boolean addTransaction(Customer customer, double transactionValue) {
        return addTransaction(customer.getName(), transactionValue);
    }

    public boolean addTransaction(String customerName, double transactionValue) {
        int customerIndex = findCustomerInBranch(customerName);

        if (customerIndex == -1) {
            return false;
        }

        customers.get(customerIndex).addTransaction(transactionValue);
        return true;

    }

    public static Branch newBranch(String name) {
        return new Branch(name);
    }
}
