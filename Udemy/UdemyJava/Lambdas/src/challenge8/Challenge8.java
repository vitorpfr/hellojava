package challenge8;

public class Challenge8 {
    // a. There are many interfaces in the Java SDK, and sometimes we can use a lambda expression instead of
    // creating an instance that implements the interface we want to use.
    // Given a specific interface, how can we tell whether we can map a lambda expression to it? What is the criteria that has to be met?

    // Answer: needs to be a functional interface (only one method that must be implemented)
    // it can contain more methods than one, but all methods but one must have default implementations

    // b. With that in mind, can we use a lambda expression to represent an instance of the java.util.concurrent.Callable interface?
//    java.util.concurrent.Callable<String>
    // Answer: Yes, because Callable is a functional interface (only has one method to be implemented, call())

    // c. Is java.util.Comparator interface a functional interface?
//    java.util.Comparator<String>
    // Answer: Yes, because although it has two non-default methods (compare and equals), equals has a
    // default implementation in the Object class (which is the superclass of Comparator)
}
