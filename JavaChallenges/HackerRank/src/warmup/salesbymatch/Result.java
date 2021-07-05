package warmup.salesbymatch;

import java.util.*;

public class Result {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> pairMapping = new HashMap<>();
        int completePairs = 0;

        for (int i : ar) {

            // update map
            if (pairMapping.containsKey(i)) {
                pairMapping.put(i, (pairMapping.get(i) + 1));
            } else {
                pairMapping.put(i, 1);
            }

            // if this color has 2 socks, set a new pair and reset count to zero
            if (pairMapping.get(i) == 2) {
                completePairs++;
                pairMapping.put(i, 0);
            }
        }

        return completePairs;

    }

    public static void main(String[] args) {
        int n = 7;
        List<Integer> ar = Arrays.asList(1, 2, 1, 2, 1, 3, 2);
        System.out.println(sockMerchant(n, ar));
    }
}
