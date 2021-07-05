package arrays.leftrotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeftRotation {
    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // if rotations number is equal to array size, they will return the same array
        if (d == a.size()) {
            return a;
        } else {
            // if number rotations is higher than array size, only remainder will actually matter
            int effectiveRotations = d % a.size();

            // loop through remainder and shift first elements to last
            for (int i = 0; i < effectiveRotations; i++) {
                Integer elementToRotate = a.get(0);
                a.remove(0);
                a.add(elementToRotate);
            }

            return a;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(rotLeft(arr, 5));
        System.out.println(rotLeft(arr, 3));
    }
}
