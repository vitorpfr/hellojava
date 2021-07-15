package strings.printstringpermutations;

public class PrintStringPermutations {

    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) { // "c", "b"
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) { // i = 0
                System.out.println(i);
                String rem = str.substring(0, i) + str.substring(i + 1); // "c" + ""
                permutation(rem, prefix + str.charAt(i)); // permutation ("c", "b")
            }
        }
    }

    // first run: ("abc", "")
        // index 0:
            // run inside: ("bc", "a")
            // index 0:
                // run inside ("c", "ab")
                // index 0:
                    // run inside ("", "abc")
                    // prints "abc"
                // index 1
                    // run inside ("c", "b"




    public static void main(String[] args) {
        System.out.println("c".substring(1));
        permutation("abc");
    }
}

//
