package arrays.findelementsincommon;

import java.util.Arrays;
import java.util.List;

// problem from the "7 steps to solve algorithm problems", from interview preparation kit, HackerRank
// https://www.hackerrank.com/interview/interview-preparation-kit/tips-and-guidelines/videos

// Given two arrays (both sorted and distinct), find the number of elements in common

public class FindElementsInCommon {

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 5, 15, 20, 30, 37);
        List<Integer> arr2 = Arrays.asList(2, 5, 13, 30, 32, 35, 37, 42);

        System.out.println(numberOfElementsInCommon(arr1, arr2));
    }

    // brute force:
    // loop through arr1, and for each element, inner loop through arr2.
    // if arr1[i] == arr2[j], add 1 to equal element counter and break inner loop
    // runtime: O(nˆ2) if arrays have same size for example (O(A*B) is more correct)

    // better method (faster but consumes more memory)
    // initialize a HashMap called map1
    // loop through arr1, map1.put(arr1[i], true), stating that this element is on array1
    // loop through arr2, on each element check if its entry on map1 is true - if it is, increment equal element counter
    // runtime O(2*n), assuming arrays have same size (O(A+B) is more correct)

    // int counter = 0
    // Map<Integer, Boolean> dataStore = new Map
    // for item in arr1:
        //  dataStore.put(item, true)
    // for item in arr2:
        // if (datastore.get(item))
            // counter++;
    // return counter;

    // good practice: modularize code before!!!
    // so, this would be in a whiteboard:
    // Map<Integer, Boolean> arr1DataStore = storeData(arr1)
    // numberOfEqualElements = processArr2(arr2)
    // return numberOfEqualElements

    // then, test! Start with small test cases, then edge cases, then big test cases

    // better method below
    // runtime: O(n), being n the largest list
    public static int numberOfElementsInCommon(List<Integer> arr1, List<Integer> arr2) {
        int i = 0;
        int j = 0;
        int commonElementsCounter = 0;


        while ((i < arr1.size()) && j < arr2.size()) {
            int comparison = arr1.get(i).compareTo(arr2.get(j));

            // current arr1 value is more than current arr2 value: increment j
            if (comparison > 0) {
                j++;
            }

            // current arr1 value is less than current arr2 value: increment i
            else if (comparison < 0) {
                i++;
            }

            // elements are equal: count and increment both indexes
            else {
                commonElementsCounter++;
                i++;
                j++;
            }
        }

        return commonElementsCounter;
    }
}
