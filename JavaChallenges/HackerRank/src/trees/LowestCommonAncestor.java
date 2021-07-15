package trees;

import java.util.*;
import java.io.*;

public class LowestCommonAncestor {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        // case 1: one of them is smaller, one of them is larger than root
        // return root
        if (((v1 > root.data) && (v2 < root.data)) || ((v1 < root.data) && (v2 > root.data))) {
            return root;
        }

        // case 2: both v1 and v2 have value less than root
        // return lca for v1 and v2, with root.left as new root
        if ((v1 < root.data) && (v2 < root.data)) {
            return lca(root.left, v1, v2);
        }

        // case 3: both v1 and v2 have value greater than root
        // return lca for v1 and v2, with root.right as new root
        if ((v1 > root.data) && (v2 > root.data)) {
            return lca(root.right, v1, v2);
        }

        // else: one of them or both are equal to root
        // return root
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}