public class BankAccount {
    private String number;
    private int balance; // should be other data type, this is just an example
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    // constructor needs to have the same name of the class
    // In the empty constructor, you can create an object with default parameters by calling the other constructor
    public BankAccount() {
        this("12345", 0, "aaa", "a@b.c", "1234");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String number, int balance, String customerName, String customerEmail, String customerPhone) {
        System.out.println("Account constructor with parameters called");
//        setNumber(number);
//        setBalance(balance);
//        setCustomerName(customerName);
//        setCustomerEmail(customerEmail);
//        setCustomerPhone(customerPhone);

        // another way
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;

    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public boolean deposit(int amount) {
        balance += amount;
        System.out.println("Amount of " + amount + " was deposited! New balance is " + balance);
        return true;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount of " + amount + " was withdrew! New balance is " + balance);
            return true;
        } else{
            System.out.println("Insufficient funds (current balance of " + balance + "), withdraw of " + amount + " aborted...");
            return false;
        }
    }
}
