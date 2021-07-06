package arrays.minimumswap;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumSwaps {

    static int indexOfPosition(int x) {
        return x - 1;
    }

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        long hops = 0;

        // loop through each element
        for (int i = 1; i <= arr.length; i++) {
            hops++;

            // do something only if current element is not in the right position already
            if (i != arr[indexOfPosition(i)]) {

                // find current position of element that should be here
                int currentIPosition = -1;
                for (int j = (i + 1); j <= arr.length; j++) {
                    hops++;

                    if (arr[indexOfPosition(j)] == i) {
                        currentIPosition = j;
                        break;
                    }
                }

                // swap current element with element found
                if (currentIPosition != -1) {
                    int temp = arr[indexOfPosition(i)];
                    arr[indexOfPosition(i)] = arr[indexOfPosition(currentIPosition)];
                    arr[indexOfPosition(currentIPosition)] = temp;
                    swaps++;
                }
            }
        }

//        System.out.println("normal: swaps: " + swaps + ", hops: " + hops);
        return swaps;

    }










    static int optMinimumSwaps(int[] arr) {
        int swaps = 0;
        long hops = 0;

        // store data of value (key) to current position (value), looping through array once
        HashMap<Integer, Integer> dataStore = new HashMap<>();
        for (int i = 1; i <= arr.length; i++) {
            hops++;
            dataStore.put(arr[indexOfPosition(i)], i);
        }

        // loop through each element
        for (int i = 1; i <= arr.length; i++) {

            hops++;

            // do something only if current element is not in the right position already
            if (i != arr[indexOfPosition(i)]) {

                // find current position of element that should be here
                int currentIPosition = dataStore.get(i);

                // swap current element with element found and update mapping
                if (currentIPosition != i) {

                    // swap
                    int temp = arr[indexOfPosition(i)];
                    int temp2 = arr[indexOfPosition(currentIPosition)];
                    arr[indexOfPosition(i)] = temp2;
                    arr[indexOfPosition(currentIPosition)] = temp;
                    swaps++;

                    // update mapping
                    dataStore.put(temp2, i);
                    dataStore.put(temp, currentIPosition);
                }
            }
        }

//        System.out.println("optimized: swaps: " + swaps + ", hops: " + hops);
        return swaps;
    }









    public static Scanner scanner;

//    static {
//        try {
//            // current directory is the project folder (JavaChallenges folder) for IntelliJ!
//            scanner = new Scanner(new File("HackerRank/src/arrays/minimumswap/biginput.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    ;

    public static void main(String[] args) throws IOException {

        try {
            // current directory is the project folder (JavaChallenges folder) for IntelliJ!
            scanner = new Scanner(new File("HackerRank/src/arrays/minimumswap/biginput.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        System.out.println("big array");
        int[] arr2 = arr.clone();

        // normal
        long start = System.currentTimeMillis();
        minimumSwaps(arr);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        // optimized
        start = System.currentTimeMillis();
        optMinimumSwaps(arr2);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        System.out.println("--------------");
        System.out.println("small arrays");
        minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6});
        minimumSwaps(new int[]{2, 3, 4, 1, 5});

        optMinimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6});
        optMinimumSwaps(new int[]{2, 3, 4, 1, 5});

        // conclusion (array of 100k elements):
        // normal (minimumSwaps) took 2492632311 hops and 3500ms
        // optimized (optMinimumSwaps) took 200000 hops and 63ms

        // optimized doesn't loop through array on every first loop occurrence; instead, it loops once (storing mappings) and then a second time to actually perform swaps
        // however, it uses more memory!
    }
}
