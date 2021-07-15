package tree.findtreeminandmax;

public class Node {
    public int key;
    public Node left;
    public Node right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}
