package search.icecreamparlor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IceCreamParlor {
    public static void whatFlavors(List<Integer> cost, int money) {
        // initialize hashmap<Integer, Integer> to store data
        HashMap<Integer, Integer> dataStore = new HashMap<>();

        // loop through array
        for (int i = 0; i < cost.size(); i++) {
            int currentValue = cost.get(i);

            // if key (money - element) exists in hashmap, return value and current position, both adjusted + 1
            if (dataStore.containsKey(money - currentValue)) {
                System.out.println((dataStore.get(money - currentValue) + 1) + " " + (i + 1));
            }

            // store in hashmap key (element) with value (its index)
            dataStore.put(currentValue, i);
        }
    }

    public static void main(String[] args) {
        whatFlavors(Arrays.asList(2, 1, 3, 5, 6), 5); // should print "1 3"

        whatFlavors(Arrays.asList(3, 4, 2, 5, 7, 1), 6); // should print "4 6"
    }
}
