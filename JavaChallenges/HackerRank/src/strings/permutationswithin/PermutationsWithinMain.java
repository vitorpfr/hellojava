package strings.permutationswithin;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithinMain {
    // From Hackerrank '3 algorithms strategies' video
    // https://www.hackerrank.com/interview/interview-preparation-kit/tips-and-guidelines/videos

    // Find all permutations of s within b (s and b are strings)

    // option 1: brute force
    // - create list of all permutations of s
    // - find all within b
    // runtime: at least O(s! * b)

    // option 2:
    // get size of s (every permutation will have this size)
    // get char frequencies of s
    // slide through b getting an s-sized substring (for loop)
        // calculate char frequencies of b and compare it to char frequencies of s
        // if equal, it is a permutation!

    // https://stackoverflow.com/questions/41515081/algorithm-find-all-permutations-of-string-a-in-string-b


    public static List<String> findPermutations(String s, String b) {

//        s.contains()


        List<String> list = new ArrayList<>();
        return list;
    }
}
