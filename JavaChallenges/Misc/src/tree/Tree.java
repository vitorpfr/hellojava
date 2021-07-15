package tree;

import java.util.Collections;

public class Tree {

    // educative.io/blog/data-structures-trees-java

    static class Node<T> {
        T key;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    public static void main(String[] args) {
        // how to make a tree?
        Node<String> root = new Node<>("root");
//        root.addChild(child);

        // types of trees
        // N-ary tree: node can have childs from 0 to N
        // e.g. binary tree: every node can have up to 2 childs

        // BST: binary search tree
        // it is a binary tree, in which every node has a key and a value

        // tree traversal and searching
        // depth-first: go until the last leaf in the left, then the next one, until all nodes are traversed
        // breadth-first: look all child nodes from parent, then look at all child nodes from child nodes, etc, until all nodes are traversed

        // DFS algorithm (uses stack):
        // 1. Pick a node. Push all adjacent nodes into a stack.
        // 2. Pop a node from that stack and push adjacent nodes into another stack.
        // 3. Repeat until the stack is empty or you have reached your goal. As you visit nodes, you must mark them as visited before proceeding, or you will be stuck in an infinite loop.

        // BFS algorithm (uses queue)
        // 1. Pick a node. Enqueue all adjacent nodes into a queue. Dequeue a node, and mark it as visited. Enqueue all adjacent nodes into another queue.
        // 2. Repeat until the queue is empty of you have met your goal.
        // 3. As you visit nodes, you must mark them as visited before proceeding, or you will be stuck in an infinite loop.

        // Search in BSTs:
        // 1. start at the root
        // 2. if the value being searched is less than the value of current node, traverse the left sub-tree. if more, traverse right sub-tree
        // 3. continue with process until you reach a node with that value or reach a leaf node, meaning that the value doesn't exist

        // difference between binary tree and binary search tree:
        // binary tree is any tree where every node has two childs
        // binary search tree is guaranteed to have left node smaller than, right node greater than
    }
}
