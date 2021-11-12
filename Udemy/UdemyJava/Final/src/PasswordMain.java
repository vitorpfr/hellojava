public class PasswordMain {
    public static void main(String[] args) {
        int pw = 674312;
        Password password = new Password(pw);
        password.storePassword();

        password.letMeIn(1); // wrong password
        password.letMeIn(674312); // right password

        // issue: what if someone overrides the stored password in the object through changing storePassword method?
        // see ExtendedPassword class, which extends from Password and saves the original password without encrypting

        // ideal: set storePassword method as final, so it can't be changed in subclasses

        // summary: if you don't want subclasses to override a specific method, set it to 'final'
    }
}
