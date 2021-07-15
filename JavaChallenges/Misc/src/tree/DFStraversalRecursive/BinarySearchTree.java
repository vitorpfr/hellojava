package tree.DFStraversalRecursive;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
    void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left subtree
        printPostOrder(node.left);

        // then recur on right subtree
        printPostOrder(node.right);

        // now deal with the node
        System.out.println(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left child
        printInOrder(node.left);

        // then print the data of the node
        System.out.println(node.key + " ");

        // now recur on right child
        printInOrder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder (top-down)*/
    void printPreOrder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreOrder(node.left);

        /* now recur on right subtree */
        printPreOrder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostOrder() {     printPostOrder(root);  }
    void printInOrder()    {     printInOrder(root);   }
    void printPreOrder()   {     printPreOrder(root);  }


    // Driver method
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // BST
        //     4
        //  2     5
        //1   3

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(); // 4 2 1 3 5

        System.out.println("\nInorder traversal of binary tree (actually traverse elements in order for BST) is ");
        tree.printInOrder(); // 1 2 3 4 5

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(); // 1 3 2 5 4
    }


}
