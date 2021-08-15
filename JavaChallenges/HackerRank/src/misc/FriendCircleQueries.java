package misc;

import java.util.*;

public class FriendCircleQueries {
    // Complete the maxCircle function below.

    public static int[] maxCircle(int[][] queries) {

        // 1 and 2 shaked: makes a friend circle of size 2
        // 3 and 4 shaked: makes another friend circle of size 2
        // 2 and 3 shaked: makes a friend circle of size 4

        // brute force solution
        // initialize a list of sets to store the existing circles
        List<HashSet<Integer>> circles = new ArrayList<>();

        // initialize int array to store results
        int[] results = new int[queries.length];
        int currentLargestCircleSize = 0;

        // loop through each query (handshake) made
        for (int i = 0; i < queries.length; i++) {
            // get people who just handshaked
            int first = queries[i][0];
            int second = queries[i][1];

            // initialize list to store groups (indexes of circles) that those people are in
            List<Integer> areInTheCircles = new ArrayList<>();

            // loop through current circles: if any of them has first or second, include them
            for (int j = 0; j < circles.size(); j++) {
                HashSet<Integer> currentCircle = circles.get(j);
                // if either first or second are in circle, add circle index to areInTheCircles
                if (currentCircle.contains(first) || currentCircle.contains(second)) {
                    areInTheCircles.add(j);
                }
            }

            // if areInTheCircles size is zero, the current elements are not in any circle. add a new circle
            if (areInTheCircles.size() == 0) {
                HashSet<Integer> newCircle = new HashSet<>();
                newCircle.add(first);
                newCircle.add(second);
                circles.add(newCircle);

                if (newCircle.size() > currentLargestCircleSize) {
                    currentLargestCircleSize = newCircle.size();
                }
            }

            // if areInTheCircles size is one, the current elements are in just one circle. add them to it
            if (areInTheCircles.size() == 1) {
                HashSet<Integer> currentCircle = circles.get(areInTheCircles.get(0));
                currentCircle.add(first);
                currentCircle.add(second);

                if (currentCircle.size() > currentLargestCircleSize) {
                    currentLargestCircleSize = currentCircle.size();
                }
            }

            // if areInTheCircles size is two, we'll need to merge those two circle
            if (areInTheCircles.size() == 2) {
                // add all elements of second circle to first cicle
                Set<Integer> firstCircle = circles.get(areInTheCircles.get(0));
                int secondCircleIndex = areInTheCircles.get(1);
                firstCircle.addAll(circles.get(secondCircleIndex));

                // add new elements to first circle
                firstCircle.add(first);
                firstCircle.add(second);

                // remove second circle from list
                circles.remove(secondCircleIndex);

                // update currentLargestCircleSize
                if (firstCircle.size() > currentLargestCircleSize) {
                    currentLargestCircleSize = firstCircle.size();
                }
            }

            // print current status of circles
//            System.out.println(circles.toString());

            // store largest circle size
            results[i] = currentLargestCircleSize;

        }

        return results;
    }

    // optimization opportunities:
    // using a different data structure

    // re-implementing using disjoint set
    // https://www.geeksforgeeks.org/disjoint-set-data-structures/

    // from the discussions - better solution
    // understand it!
    static class UnionFind {
        Map<Integer, Integer> parents;
        Map<Integer, Integer> sizes;
        int max;
        public UnionFind() {
            parents = new HashMap<>();
            sizes = new HashMap<>();
            max = 0;
        }

        public void union(int v1, int v2) {
            System.out.println("Starting union of " + v1 + " and " + v2);
            // if v1 is not in the parent list, add it there as a parent with size 1
            if (!parents.containsKey(v1)) {
                parents.put(v1, v1);
                sizes.put(v1, 1);
            }

            // if v2 is not in the parent list, add it there as a parent with size 1
            if (!parents.containsKey(v2)) {
                parents.put(v2, v2);
                sizes.put(v2, 1);
            }

            // find parents of v1 and v2
            // if v1 and v2 have same parents, don't do anything (they're already union'd)
            // this method also sets v1's parent recursively
            int p1 = find(v1), p2 = find(v2);
            System.out.println(v1 + " parent is " + p1 + ", " + v2 + " parent is " + p2);
            if (p1 == p2) return;

            // else, we'll now actually union the groups with parents p1 and p2
            // get size of v1 and v2 parents
            int s1 = sizes.get(p1), s2 = sizes.get(p2);
            System.out.println(v1 + " size is " + s1 + ", " + v2 + " size is " + s2);

            // merge groups by having the largest group unchanged
            // if s1 is less than s2, define new p1's parent as p2, and increase p2 size
            if (s1 < s2) {
                parents.put(p1, p2);
                sizes.put(p2, s1 + s2);

            // else, do the opposite
            } else {
                parents.put(p2, p1); // 2s parent is now 1
                sizes.put(p1, s1 + s2); // 1s size is now (1 + 1)
            }

            // if this new group has a higher size than max, update max
            if (s1 + s2 > max) max = s1 + s2;
        }

        public int find(int v) {
            // parents.get(v) is equal to v when we found the parent element of a group
            // loop until we find the parent of v
            while (parents.get(v) != v) { // parents.get(3) = 1 != 3
                System.out.println("executing while loop for " + v);
                parents.put(v, parents.get(parents.get(v))); //parents.put(3, 1)
                v = parents.get(v); // parents.get(3), which is 1
            }
            return v;
        }
    }

    // Complete the maxCircle function below.
    static int[] betterMaxCircle(int[][] queries) {
        UnionFind uf = new UnionFind();
        int[] res = new int[queries.length];
        System.out.println("parents: " + uf.parents + ", sizes: " + uf.sizes);
        for (int i = 0; i < queries.length; i++) {
            uf.union(queries[i][0], queries[i][1]);
            res[i] = uf.max;
            System.out.println("parents: " + uf.parents + ", sizes: " + uf.sizes);
        }
        return res;
    }



    public static void main(String[] args) {
        int[][] queries = new int[4][4];
        // handshake: 1 with 2
        queries[0][0] = 1;
        queries[0][1] = 2;

        // handshake: 1 with 3
        queries[1][0] = 1;
        queries[1][1] = 3;

        // handshake: 5 with 6
        queries[2][0] = 5;
        queries[2][1] = 6;

        // handshake: 6 with 2
        queries[3][0] = 6;
        queries[3][1] = 2;

        System.out.println(Arrays.toString(betterMaxCircle(queries)));
    }
}
