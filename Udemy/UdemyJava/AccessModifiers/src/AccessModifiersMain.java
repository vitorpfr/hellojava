public class AccessModifiersMain {
    public static void main(String[] args) {
        Account timsAccount = new Account("Tim");

        timsAccount.deposit(1000);
        timsAccount.withdraw(500);
        timsAccount.withdraw(-200);
        timsAccount.deposit(-20);
        timsAccount.calculateBalance();
//        timsAccount.balance = 5000; //  this is not allowed with private fields


        System.out.println("Balance on account is " + timsAccount.getBalance());

//        timsAccount.transactions.add(4500); // this is not allowed with private fields
        timsAccount.calculateBalance();
    }
}
