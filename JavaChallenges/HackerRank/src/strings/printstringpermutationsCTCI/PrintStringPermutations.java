package strings.printstringpermutationsCTCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintStringPermutations {
    // Example: Design an algorithm to print all permutations of a string. For simplicity, assume all characters are unique.

    // case a: a
    // case ab: ab, ba (insert b in all indexes of all "case a" results)
    // case abc: insert c in all indexes of all "case ab" results
    // case abcd: insert d in all indexes of all  "case abc" results

    // objective: build a recursive solution:
    // base cases: null string and string with one character (return themselves)
    // otherwise: save permutations of string with 1 character less, then loop through it adding one character in each index

    public static List<String> getPermutations(String str) {

        List<String> allPermutations = new ArrayList<>();

        if (str.length() == 0) {
            allPermutations.add("");
        } else if (str.length() == 1) {
            allPermutations.add(str);
        } else {
            // generate permutations of s(0) to s(n-1)
            String firstCharacters = str.substring(0, str.length() - 1);
            String lastCharacter = str.substring(str.length() - 1);
            List<String> partOfPermutations = getPermutations(firstCharacters);

            // loop through list, adding new permutations as they are built
            for (int i = 0; i < partOfPermutations.size(); i++) {
                // get current permutation and add it to new list
                String currentPermutation = partOfPermutations.get(i);

//                allPermutations.add(str);

                // for each string index, we build a new permutation and also add it to list
                for (int j = 0; j < currentPermutation.length() + 1; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(currentPermutation.substring(0, j));
                    sb.append(lastCharacter);
                    sb.append(currentPermutation.substring(j));

                    System.out.println("i=" + i + ", j=" + j + ", added " + sb.toString());
                    allPermutations.add(sb.toString());
                }
            }
        }

        // return list built
        return allPermutations;

    }

    public static void main(String[] args) {
//        System.out.println(getPermutations("ab"));
//        System.out.println(getPermutations("abc"));
        System.out.println(getPermutations("abcd"));
    }
}
