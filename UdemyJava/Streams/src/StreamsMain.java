import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// observations about stream:
// - they can't be reused: once a terminal operation has been called in a stream, it can't be used anymore
// - operations are lazily evaluated, which means intermediate operations are not performed until there is a terminal operation (like seq in clojure)
// - there are specific streams for primitives: IntStream, LongStream, etc. These streams have additional methods such as min, max, etc
// - there are parallel streams, which can be processed in parallel (parallelStream method)

public class StreamsMain {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        // filtering G and sorting by number
        // right now it is a 4-step process: create aux list, add numbers that match condition to list, sort aux list, and print each value
//        List<String> gNumbers = new ArrayList<>();
//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort(String::compareTo); // same as (s1, s2) -> s1.compareTo(s2)
//        gNumbers.forEach(System.out::println); // same as s -> System.out.println(s)

        // using Streams, you could do all of this with one statement, as below
        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println); // accepts a consumer and executes it for each element
        // all intermediate steps accept a stream and return a stream
        // forEach is a terminal operation - either returns void or a non-stream result

        // stream: A sequence of elements supporting sequential and parallel aggregate operations
        // each object reference in the stream corresponds to an object in the collection, initially with the same ordering
        // any operations on this straem do not change the source data, because every operation returns a new stream

        // here you can see that the source was not changed (a new immutable Stream is produced)
        System.out.println(someBingoNumbers);

        // map-reduce example (not from the class)
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbersList.stream().map(i -> i + 1).reduce(Integer::sum).get(); // get needed because it returns an optional
        System.out.println(sum);

        // we can also create a stream from scratch instead of basing it in a existing collection
        var ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        var inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        var concatStream = Stream.concat(ioNumberStream, inNumberStream);
//        System.out.println(concatStream.count()); // count is a terminal operation, prints 10
//        System.out.println(concatStream.distinct().count()); // now prints 6, because it removed duplicated elements

        // use case: we want to debug inside a chain => can we print the items in a chain without ending the chain?
        // we can use peek method to execute some code on each element, but also return a new stream
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        // showing how streams are lazily evaluated:
        // the code below doesn't print anything because filter is lazy, so it is not executed until a terminal command is there
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });

        // now, with a terminal operation, the code block inside the filter predicate will be executed
        // and all the elements will be printed
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 2;
                })
                .count();
    }
}
