package search.swapnodes;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

public class SwapNodes {
    static class Node {
        Node parent;
        Node left;
        Node right;
        int depth;
        int value;

        public Node(int value, Node parent) {
            this.parent = parent;
            this.left = null;
            this.right = null;
            this.value = value;
            if (parent == null) {
                depth = 1;
            } else {
                depth = getDepth(this);
            }
        }

        public int getDepth() {
            return depth;
        }

        public static int getDepth (Node node) {
            return (node.parent.getDepth() + 1);
        }
    }

    public static void traverseInOrder(Node node, List<Integer> kResult) {
        if (node == null) return;

        traverseInOrder(node.left, kResult);
        kResult.add(node.value);
        traverseInOrder(node.right, kResult);
    }


    public static void startTraverseInOrder(Node root, List<Integer> kResult) {
        traverseInOrder(root, kResult);
    }

    public static void swap(Node node) {
        Node temp = node.right;
        node.right = node.left;
        node.left = temp;
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // input:
        // 2 3 -> childs of node 1
        // -1 -1 -> childs of node 2 (2)
        // -1 -1 -> childs of node 3 (3)
        // 1 1 -> each value is a k (for which a swap operation will be performed)

        // create array to store nodes according to index
        List<Node> nodeArray = new ArrayList<>();

        // create root and add to nodeArray
        Node root = new Node(1, null);
        nodeArray.add(root);

        // build tree of nodes, storing each node in nodeArray
        int i = 0;
        while (i < nodeArray.size()) {
            Node current = nodeArray.get(i);

            Node leftNode = (indexes.get(i).get(0) == -1) ? null : new Node(indexes.get(i).get(0), current);
            Node rightNode = (indexes.get(i).get(1) == -1) ? null : new Node(indexes.get(i).get(1), current);

            if (leftNode != null) {
                nodeArray.add(leftNode);
            }
            if (rightNode != null) {
                nodeArray.add(rightNode);
            }

            current.left = leftNode;
            current.right = rightNode;
            i++;
        }

        // initialize list to store result
        List<List<Integer>> result = new ArrayList<>();

        // loop through each query element and call it k
        for (int k : queries) {

            // initialize list to store traversal of tree after this k is processed
            List<Integer> kResult = new ArrayList<>();

            // loop through each node of tree
            for (Node node : nodeArray) {
                // if depth is a multiple of k, perform swap operation
                if ((node.depth % k) == 0) {
                    swap(node);
                }
            }

            // for each k, traverse array and store traverse result in kResult. Add kResult to result
            startTraverseInOrder(root, kResult);
            result.add(kResult);
        }

        return result;

    }
}
