package meeting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Meeting {
    // https://www.codewars.com/kata/59df2f8f08c6cec835000012/train/java

    public static String meeting(String s) {
        String[] upperCaseNames = s.toUpperCase().split(";");

        return Arrays.stream(upperCaseNames)
                .map((String x) -> x.split(":"))
                .sorted((String[] x, String[] y) -> x[1].compareTo(y[1]) == 0 ? x[0].compareTo(y[0]) : x[1].compareTo(y[1]))
                .map((String[] x) -> "(" + x[1] + ", " + x[0] + ")")
                .collect(Collectors.joining(""));
}
