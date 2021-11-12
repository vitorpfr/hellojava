public class FinalMain {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        // error: cannot change the value of a final variable!
//        one.instanceNumber = 4;

        // Math.PI is a public static final, because its value is the same regardless of instances, and it also doesn't change
        System.out.println(Math.PI);

        // doesn't work because Math class constructor is private, so no one can instantiate this class
        // this is done because all Math methods are static (don't need to have a Math instance to be used)
//        Math m = new Math();

        // Math is also a 'public final' class, which means it cannot be extended

        // 'final' methods cannot be overriden as well: see Password class


    }
}
