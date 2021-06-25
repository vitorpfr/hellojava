package bankingchallenge;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    private int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return i;
            }
        }

        return -1;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != -1) {
            return false;
        }

        branches.add(Branch.newBranch(branchName));
        return true;
    }

    public boolean addCustomerToBranch(String branchName, String customerName, double initialTransactionValue) {
        int branchIndex = findBranch(branchName);

        if (findBranch(branchName) == -1) {
            return false;
        }

        // doesn't need to check if the customer doesn't exist because addTransaction already does this!
        return branches.get(branchIndex).addCustomer(customerName, initialTransactionValue);
    }

    public boolean addTransactionToCustomer(String branchName, String customerName, double transactionValue) {
        int branchIndex = findBranch(branchName);

        if (findBranch(branchName) == -1) {
            return false;
        }

        // doesn't need to check if the customer exists because addTransaction already does this!
        return branches.get(branchIndex).addTransaction(customerName, transactionValue);
    }

    public void printListOfBranches() {
        if (branches.size() == 0) {
            System.out.println("No branches on bank " + getName() + ".");
        } else {

            System.out.println("Branches on bank " + getName() + ": ");
            for (int i = 0; i < branches.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + branches.get(i).getName());
            }
        }
    }

    public void printListOfCustomers(String branchName) {
        printListOfCustomers(branchName, false);
    }
    
    public void printListOfCustomers(String branchName, boolean shouldPrintTransactions) {
        int branchIndex = findBranch(branchName);

        if (branchIndex == -1) {
            System.out.println("Branch " + branchName + " not found.");
            return;
        }

        Branch branch = branches.get(branchIndex);

        if (branch.getCustomers().size() == 0) {
            System.out.println("No customers on this branch yet.");
            return;
        }

        System.out.println("List of customers for bank " + getName() + ": ");
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + branch.getCustomers().get(i).getName());
            if (shouldPrintTransactions) {
                System.out.println("\t   Transactions: " + branch.getCustomers().get(i).getTransactions().toString());
            }
        }
    }
}
