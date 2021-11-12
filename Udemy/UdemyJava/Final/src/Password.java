public class Password {
    private static final int key = 52355215;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    // this is not safe or a best practice - it is just an example!!!
    private int encryptDecrypt(int password) {
        return password ^ key; // XOR operation
    }

    public void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);

    }

    public boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Access denied");
            return false;
        }
    }
}
