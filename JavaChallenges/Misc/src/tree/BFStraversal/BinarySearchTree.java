package tree.BFStraversal;

import tree.DFStraversalNonRecursive.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // idea: get element from queue, print (or return), and only then add its children to queue
    // rinse and repeat
    public void traverseWithoutRecursion() {
        Queue<Node> queue = new ArrayDeque<>();
        Node current = root;
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.remove();

            // return current would be here if we're trying to find an element
            System.out.println(current.key + " ");

            // add children to queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void traverseWithRecursion(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.key + " ");

        traverseWithRecursion(node.left);

        traverseWithRecursion(node.right);
    }

    public void traverseWithRecursion() {
        traverseWithRecursion(root);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new tree.DFStraversalNonRecursive.Node(4);
        tree.root.left = new tree.DFStraversalNonRecursive.Node(2);
        tree.root.right = new tree.DFStraversalNonRecursive.Node(5);
        tree.root.left.left = new tree.DFStraversalNonRecursive.Node(1);
        tree.root.left.right = new Node(3);

        // BST
        //     4
        //  2     5
        //1   3

        // queue removes elements in the same order they were added (FIFO)
        // we also add all children of each "row" before moving to next one
        tree.traverseWithoutRecursion();


        // it is not possible to do BFS recursive, because the nature of recursive calls is to add it to a stack
        // and breadth-first search depends on a queue algorithm


    }
}
