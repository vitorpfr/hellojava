public class StaticInitializationBlock {
    public static final String owner;

    // equivalent of a constructor, but for the whole class (instead of a instance/object)
    static {
        owner = "tim";
        System.out.println("Static initialization block called");
    }

    public StaticInitializationBlock() {
        System.out.println("Constructor called");
    }

    static {
        System.out.println("2nd static initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
