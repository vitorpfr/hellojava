public class StaticInitializationBlockTest {
    public static void main(String[] args) {
        System.out.println("Main method called");

        // this shows the static initialization blocks being called in order of declaration
        // (equivalent to constructor, but for the class itself, not for instances)
        StaticInitializationBlock test = new StaticInitializationBlock();
        test.someMethod();
        System.out.println("Owner is " + StaticInitializationBlock.owner);
    }
}
