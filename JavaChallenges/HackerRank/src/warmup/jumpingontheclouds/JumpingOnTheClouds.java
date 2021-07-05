package warmup.jumpingontheclouds;

import java.util.Arrays;
import java.util.List;

public class JumpingOnTheClouds {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {

        int steps = 0;
        int position = 0;

        while (true) {
            // exit condition: if current cloud is the last, exit loop and return number of steps taken
            if (position == (c.size() - 1)) {
                return steps;
            }

            // perform a walk (could be a separate method)
            // if 2 clouds later is safe (and exists), walk 2 clouds
            // otherwise, walk 1 cloud
            boolean isPossibleToWalkTwoClouds = (position != (c.size() - 2));
            boolean isSafeToWalkTwoClouds = isPossibleToWalkTwoClouds && (c.get(position + 2) == 0);

            if (isSafeToWalkTwoClouds) {
            position += 2;
            } else {
                position++;
            }

            // add step and continue loop
            steps++;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(0, 1, 0, 0, 0, 1, 0);
        System.out.println(jumpingOnClouds(arr));

        List<Integer> arr2 = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        System.out.println(jumpingOnClouds(arr2));

    }
}
