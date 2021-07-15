package trees;

import java.util.Scanner;

public class HeightOfABinaryTree {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        Node cur;
        if (data <= root.data) {
            cur = insert(root.left, data);
            root.left = cur;
        } else {
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        if (node.left == null && node.right == null) {
            return 0;
        }

        if (node.left == null) {
            return getHeight(node.right) + 1;
        }

        if (node.right == null) {
            return getHeight(node.left) + 1;
        }

        int leftSideHeight = getHeight(node.left) + 1;
        int rightSideHeight = getHeight(node.right) + 1;

        return (leftSideHeight > rightSideHeight) ? leftSideHeight : rightSideHeight;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = getHeight(root);
        System.out.println(height);
    }
}
