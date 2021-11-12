package challenge9to14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge9to14 {
    public static void main(String[] args) {
        // Challenge 9: Write code to print the items of the list below in sorted order, and with the first letter in each name upper-cased

        // Challenge 10: Change the lambdas to use method reference

        // Challenge 11: Do it using streams

        // Challenge 12: Instead of printing out the sorted names, print out how many names begin with the letter 'A' instead

        // Challenge 13: In the challenge 11 code, use peek() to print out the names after the map() method has executed

        // Challenge 14: Add a terminal operation so peek() code is executed

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        // challenge 9 (using forEach)
        System.out.println("Challenge 9 output:");
        List<String> topNames2015InOrderCapitalized = new ArrayList<>();
        topNames2015.forEach(s -> {
            topNames2015InOrderCapitalized.add(firstLetterToUpperCase(s));
        });
        topNames2015InOrderCapitalized.sort((s1, s2) -> s1.compareTo(s2)); // equivalent to String::compareTo
        topNames2015InOrderCapitalized.forEach(System.out::println);

        // challenge 11 (using stream)
        System.out.println("----------------------");
        System.out.println("Challenge 11 output:");
        topNames2015.stream()
                .map(Challenge9to14::firstLetterToUpperCase) // equivalent to String s -> firstLetterToUpperCase(s)
                .sorted(Comparator.naturalOrder()) // equivalent to (s1, s2) -> s1.compareTo(s2)
                .forEach(System.out::println); // equivalent to s -> System.out.println(s)

        // challenge 12
        System.out.println("----------------------");
        System.out.println("Challenge 12 output:");
        long count = topNames2015.stream()
                .filter(s -> s.toLowerCase().startsWith("a"))
                .count();
        System.out.println(count);

        // challenge 13 and 14
        System.out.println("----------------------");
        System.out.println("Challenge 13 output:");
        topNames2015.stream()
                .map(Challenge9to14::firstLetterToUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .sorted()
                .collect(Collectors.toList()); // peek only works because of this terminal operation (because it stream chain is lazy)

    }

    public static String firstLetterToUpperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
