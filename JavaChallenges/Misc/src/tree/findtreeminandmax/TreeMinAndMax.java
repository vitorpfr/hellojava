package tree.findtreeminandmax;

import java.util.HashMap;
import java.util.Map;

public class TreeMinAndMax {
    // Exercise: Find size, maximum and minimum values of a binary tree

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(40);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(71);

        System.out.println("Recursive:");
        tree.findMinMaxSizeRecursive();

        System.out.println("Non-recursive:");
        tree.findMinMaxSizeNonRecursive();

        // time complexity of both: O(n) (traverse through all nodes)
        // space complexity of recursive: O(h), where h is the height of the tree (calls stack is this size in worst case)
    }
}
