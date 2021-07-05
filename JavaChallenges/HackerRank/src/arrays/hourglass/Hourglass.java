package arrays.hourglass;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Hourglass {
    public static int calculateHourglassSum(int i, int j, List<List<Integer>> arr) {
        int topRow = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j) + arr.get(i - 1).get(j + 1);
        int centerRow = arr.get(i).get(j);
        int bottomRow = arr.get(i + 1).get(j - 1) + arr.get(i + 1).get(j) + arr.get(i + 1).get(j + 1);

        return (topRow + centerRow + bottomRow);
    }

    public static int hourglassSum(List<List<Integer>> arr) {
       // initialize array to store hourglass sums
       List<Integer> hourglassSums = new ArrayList<>();

        // loop through center elements i, j (they are the center of each hourglass)
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {

                // calculate the sum of the hourglass of center (i. j) and add to the sum array
                hourglassSums.add(calculateHourglassSum(i, j, arr));
            }
        }

        // return the max value of the sum array
        return Collections.max(hourglassSums);
    }

    public static void main(String[] args) throws IOException {
;
        List<List<Integer>> arr = new ArrayList<>();
        hourglassSum(arr);
    }
}
