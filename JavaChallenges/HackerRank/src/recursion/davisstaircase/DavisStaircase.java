package recursion.davisstaircase;

import java.util.HashMap;
import java.util.Map;

public class DavisStaircase {

    // 1, 2 or 3 steps at a time
    // find ways to sum to n

    // n = 1
    // 1 (1 way)

    // n = 2
    // 1 1, 2 (2 ways)

    // n = 3
    // 1 1 1, 1 2, 2 1, 3 (4 ways)

    // n = 4
    // 1111, 211, 121, 112, 31, 13, 22 (7 ways)

    // n = 5
    // 11111, 2111, 1211, 1121, 1112, 311, 131, 113, 221, 212, 122, 23, 32  (13 ways)

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int stepPerms(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int value = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
            cache.put(n, value);
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(stepPerms(1));
        System.out.println(stepPerms(2));
        System.out.println(stepPerms(3));
        System.out.println(stepPerms(4));
        System.out.println(stepPerms(5));
    }
}
