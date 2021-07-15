package greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {

    // brute force method:
    // initialize int minValue as Integer.MAX_VALUE
    // loop through arr, index i
        // loop through arr, index j
            // if i != j, calculate absolute difference of arr[i] and arr[j]
            // store in minValue if it's smaller than current one stored
    // return minValue

    // runtime: O(n^2)

    // possible optimizations:
    // if array has 2 elements, return its absolute difference already

    // other approach:
    // sort array
    // initialize minValue as the difference between the first two elements
    // loop through array and compare diff of each pair to value stores
    // return value stored

    public static int absoluteDifference(int i1, int i2) {
        int diff = i1 - i2;
        return (diff < 0) ? -diff : diff;
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {

        // sort array
        Collections.sort(arr);

        int minValue = absoluteDifference(arr.get(0), arr.get(1));
        int challenger;

        for (int i = 1; i < arr.size() - 1; i++) {
            challenger = absoluteDifference(arr.get(i), arr.get(i+1));
            if (challenger < minValue) {
                minValue = challenger;
            }
        }

        return minValue;

    }

    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(Arrays.asList(3, -7, 0)));
        System.out.println(minimumAbsoluteDifference(Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)));
        System.out.println(minimumAbsoluteDifference(Arrays.asList(1, -3, 71, 68, 17)));
    }
}
