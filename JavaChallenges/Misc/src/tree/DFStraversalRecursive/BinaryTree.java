package tree.DFStraversalRecursive;

public class BinaryTree {
    Node root;

    BinaryTree() {
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




    public static Node findNodeInTree(Node node, int value) {
        if (node == null) {
            return null;
        }

        findNodeInTree(node.left, value);

        System.out.println("Checking current element " + node.key);
        if (node.key == value) {
            System.out.println("Gotcha! " + value + " was found");
            return node;
        }

        findNodeInTree(node.right, value);

        return null;

    }

    // traverse tree using DFS, and when finding element equal to value, sinalizes it
    public void findElementInTree(int value) {
        findNodeInTree(root, value);
    }

    // Driver method
    public static void main(String[] args)
    {
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

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(); // 1 2 4 5 3

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder(); // 4 2 5 1 3

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(); // 4 5 2 3 1

        System.out.println("Using DFS to find an element in a binary search");
        tree.findElementInTree(4);
    }


}
