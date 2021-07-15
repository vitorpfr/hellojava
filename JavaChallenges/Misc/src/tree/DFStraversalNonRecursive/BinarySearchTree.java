package tree.DFStraversalNonRecursive;


import java.util.Stack;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // in-order traverse not using recursion
    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            while (current.left != null) {
                current = current.left;
                stack.push(current);
            }

            current = stack.pop();
            // return current would be here if we're trying to find an element
            System.out.println(current.key + " ");

            if (current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // BST
        //     4
        //  2     5
        //1   3

        // adds 4 to stack
        // current is 2, add 2 to stack
        // current is 1, add 1 to stack
        // get 1 (pop) and print
        // get 2 (pop) and print
        // 2 has right, so adds 3 to stack
        // get 3 (pop) and print
        // get 4 (pop) and print
        // 4 has right, so adds 5 to stack
        // get 5 (pop) and print
        tree.traverseInOrderWithoutRecursion(); // 1 2 3 4 5


    }
}
