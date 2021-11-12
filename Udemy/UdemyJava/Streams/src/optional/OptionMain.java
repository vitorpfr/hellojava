package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionMain {
    // this is not covered in the course
    public static void main(String[] args) {
        // optionals make variables explicit regarding nullabe or non-nullable behavior
        Integer value1 = null;
        Integer value2 = 10;

        //// Creating Optional

        // Optional.ofNullable - allows passed parameter to be null
//        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> a = Optional.empty(); // better version

        //Optional.of - throws NullPointerException if passed parameter is null
//        Optional<Integer> b = Optional.of(value1); // throws exception
        Optional<Integer> b = Optional.of(value2);

        //// Using Optional values

        // Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent()); // false
        System.out.println("Second parameter is present: " + b.isPresent()); // true

        // Optional.orElse - returns the value if present otherwise returns a default value
        System.out.println(a.orElse(0)); // prints 0 because a is null
        System.out.println(b.orElse(0)); // prints 10

        System.out.println("-----");

        // Optional.get - gets the value, throws exception if null is stored
//        System.out.println(a.get()); // throws NoSuchElementException because a is null
        System.out.println(b.get());

        // Optional.orElseThrow is equivalent to get (and preferred)

        System.out.println("-----");

        // Optional.ifPresent: receives a consumer that executes if Optional is not null
        a.ifPresent(System.out::println); // doesn't do anything
        b.ifPresent(System.out::println); // prints 10

        System.out.println("-----");

        // It is possible to chain stream operations in a optional, such as .map and .flatMap
        System.out.println(b.map(i -> i + 10).get()); // prints 20
        System.out.println(b.get()); // prints 10 (showing that the stream above does not change original result)

        System.out.println("-----");

        // Optional.or: receives a supplier to provide a value
        Supplier<Optional<Integer>> alwaysGives5 = () -> Optional.of(5);
        System.out.println(a.or(alwaysGives5).get()); // prints 5
        System.out.println(b.or(alwaysGives5).get()); // prints 10 (original value)

        System.out.println("-----");

        // an use case of isPresent
        if (b.isPresent()) {
            System.out.println("Value is present and is " + b.get());
        } else {
            System.out.println("Value is not present");
        }





    }
}
