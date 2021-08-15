package tree.BFSaveragebylevel;

// Exercise: Given a root of binary tree, get the average of each level. Return a List of the averages
// ex:
//    4
//  3   7
//30 28  32

// result: List(4, 5, 30)

import java.util.*;

public class BFSAverageByLevel {

    public static List<Double> getAveragesByLevel(Node root) {
        // perform BFS (using a queue) to go through all nodes, level by level
        // for a given level, calculate the sum and count, divide, and add avg to result list

        if (root == null) {
            return null;
        }

        // start queue and add root with depth 1
        Queue<TreeElement> queue = new LinkedList<>(); // could be both LinkedList and ArrayDeque
        // https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        queue.add(new TreeElement(root, 1));

        // start sum and count temp ints
        int sum = 0;
        int count = 0;

        // start result array and pointer
        List<Double> result = new ArrayList<>();
        TreeElement currentElement;

        // loop while queue has elements
        while (!queue.isEmpty()) {
            // poll next queue element
            currentElement = queue.poll();

            // add element childs to queue, if any
            if (currentElement.node.left != null) {
                queue.add(new TreeElement(currentElement.node.left, currentElement.depth + 1));
            }
            if (currentElement.node.right != null) {
                queue.add(new TreeElement(currentElement.node.right, currentElement.depth + 1));
            }

            // add element data to sum and count
            count++;
            sum += currentElement.node.value;

            // if next element has different depth or queue is empty, calculate average and add to result
            if (queue.isEmpty() || (queue.peek().depth != currentElement.depth)) {
//                System.out.println("calculating average: " + sum + " over " + count);
                result.add(((double) sum) / ((double) count));

                // restart counters
                sum = 0;
                count = 0;
            }
        }

        return result;
    }

    static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class TreeElement {
        Node node;
        int depth;

        TreeElement (Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        // initialize binary tree
        //    4
        //  3   7
        //30 28  32
        Node root = new Node(4);

        root.left = new Node(3);
        root.left.left = new Node(30);
        root.left.right = new Node(28);


        root.right = new Node(7);
        root.right.right = new Node(32);

        // run function for root
        System.out.println(getAveragesByLevel(root));

    }
}
