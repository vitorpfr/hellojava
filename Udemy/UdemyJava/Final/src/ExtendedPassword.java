public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password; // note that this is not encrypting the received password before saving
    }

    @Override
    public void storePassword() {
        System.out.println("Saving password as " + this.decryptedPassword);
    }
}
