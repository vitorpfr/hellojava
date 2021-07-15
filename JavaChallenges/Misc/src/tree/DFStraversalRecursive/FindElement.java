package tree.DFStraversalRecursive;

public class FindElement {
    // using DFS to find an element in a binary tree (not BST)
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // tree (it is NOT a binary search tree! elements are not ordered):
        //     1
        //  2     3
        //4   5
    }
}
