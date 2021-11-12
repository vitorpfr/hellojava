public class Main {
    public static void main(String[] args) {
        Car porsche = new Car();
        Car holden = new Car();

        // a way to access data, not good because it violates encapsulation
//        porsche.model = "Carrera";

        // recommended way
//        System.out.println(porsche.getModel()); // null
        porsche.setModel("911");
        System.out.println("Model is " + porsche.getModel()); // Carrera

        // creates a bank account with default values (set in the empty constructor)
        BankAccount myAccount = new BankAccount();
        System.out.println(myAccount.getCustomerEmail());
        myAccount.setBalance(100);
        System.out.println(myAccount.getBalance());
        myAccount.deposit(400);
        System.out.println(myAccount.getBalance());
        myAccount.withdraw(500);
        myAccount.withdraw(1);

        // creates a bank account using the normal constructor, passing the values
        BankAccount myOtherAccount = new BankAccount("12345", 0, "Vitor", "vitorfr@gmail.com", "123456789");
        System.out.println(myOtherAccount.getCustomerEmail());

        // testing VipCustomer
        System.out.println();
        System.out.println("testing vip customer");
        var vc1 = new VipCustomer();
        System.out.println(vc1);

        var vc2 = new VipCustomer("John", "john@gmail.com");
        System.out.println(vc2);

        var vc3 = new VipCustomer("Mary", 1000, "mary@gmail.com");
        System.out.println(vc3);
    }
}
