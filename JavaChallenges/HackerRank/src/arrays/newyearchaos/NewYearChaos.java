package arrays.newyearchaos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;

        // loop from position 1 to position n
        for (int currentPosition = 1; currentPosition <= q.size(); currentPosition++) {
            int sticker = q.get(currentPosition - 1);           // index in array is 1 less than position number;

            // if sticker is 3 or more from index, certainly there were more than two bribes by one person - end loop
            if ((sticker - currentPosition) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // otherwise, for sure bribe happened here
            // everytime a person is bribed, it moves one position backward in the queue
            // here we loop from one in front of this person original position, to one in front of this person current position
            // if we find in any of those a sticker higher than this person sticker, it means that we found who bribed this person
            // so we add 1 to the bribes variable
//            System.out.println("-------------------");
//            System.out.println("I'm analyzing position " + currentPosition + ", which has sticker " + sticker);
//            System.out.println("I'll loop from index " + Math.max(0, sticker - 2) + " to " + (currentPosition - 1));
            for (int j = Math.max(0, sticker - 2); j < (currentPosition - 1); j++) {
//                System.out.println("On index " + j + ", comparing " + q.get(j) + " > " + sticker);
                if (q.get(j) > sticker) {
//                    System.out.println("Bribe confirmed");
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);

        minimumBribes(arr);
    }
}
