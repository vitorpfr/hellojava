package tree.findtreeminandmax;

import java.util.Stack;

public class BinaryTree {
    public Node root;
    public int min;
    public int max;
    public int size;

    public BinaryTree() {
        root = null;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
    }

    public void findMinMaxSizeRecursive(Node node) {
        if (node == null) {
            return;
        }

        findMinMaxSizeRecursive(node.left);

        size++;
        if (node.key < min) {
            min = node.key;
        }
        if (node.key > max) {
            max = node.key;
        }

        findMinMaxSizeRecursive(node.right);
    }

    public void findMinMaxSizeRecursive() {
        findMinMaxSizeRecursive(root);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("size: " + size);
    }

    public void findMinMaxSizeNonRecursive() {
        // initialize values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = 0;

        // initialize current node
        Node current = root;

        // initialize stack and add root
        Stack<Node> stack = new Stack<>();
        stack.add(current);

        // while stack has elements, process them
        while (!stack.isEmpty()) {
            // while there are elements left to current, add them to stack
            while (current.left != null) {
                current = current.left;
                stack.add(current);
            }

            // get current element from top of stack and process it
            current = stack.pop();
            size++;
            if (current.key > max) {
                max = current.key;
            }
            if (current.key < min) {
                min = current.key;
            }

            // while there are elements right to current, add them to stack
            while (current.right != null) {
                current = current.right;
                stack.add(current);
            }
        }

        System.out.println("Min " + min);
        System.out.println("Max " + max);
        System.out.println("Size " + size);

    }
}
