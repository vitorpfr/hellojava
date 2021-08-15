package hashmaps.ransomnote;

import java.util.HashMap;
import java.util.List;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

public class RansomNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {

        // initialize hashmap<String,Integer> to store count of words in magazine
        HashMap<String, Integer> magazineWordStore = new HashMap<>();

        // loop through magazine and increment count of each word
        for (String word : magazine) {

            Integer count = magazineWordStore.get(word);

            if (count == null) {
                magazineWordStore.put(word, 1);
            } else {
                magazineWordStore.put(word, count + 1);
            }

        }

        // loop through note, word by word
        for (String word : note) {
            Integer count = magazineWordStore.get(word);

            // if current word is not a key in the hashmap or has count 0, return false
            if (count == null || count == 0) {
                System.out.println("No");
                return;
            }

            // else
            else {
                // decrement 1 of current word value
                magazineWordStore.put(word, count - 1);
            }

        }
        System.out.println("Yes");

    }
}
