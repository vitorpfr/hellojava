package bankingchallenge;

public class Test {
    public static void main(String[] args) {
        var bank = new Bank("myBank");

        bank.addBranch("FLA");

        bank.printListOfCustomers("F");
        bank.printListOfCustomers("FLA");

        System.out.println(bank.addCustomerToBranch("FL", "Jim", 4));
        System.out.println(bank.addCustomerToBranch("FLA", "Jim", 4));
        System.out.println(bank.addCustomerToBranch("FLA", "Jim", 4));
        System.out.println(bank.addCustomerToBranch("FLA", "Tom", 75.4));
        System.out.println(bank.addTransactionToCustomer("FLA", "To", 30.1));
        System.out.println(bank.addTransactionToCustomer("FLA", "Tom", 30.1));

        bank.printListOfCustomers("FLA", true);
        bank.printListOfCustomers("FLA");

        bank.addBranch("BOT");
        bank.printListOfBranches();
    }

}
