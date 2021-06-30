package abstractclasschallenge;

public class SearchTreeTest {
    public static void main(String[] args) {
        SearchTree tree = new SearchTree(null);

        String stringData = "5 2 3 4 6 7";

        String[] data = stringData.split(" ");
        for (String s : data) {
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
        // explanation for each addition:
        // 5: there's no root, so we set 5 as root
        // 2: smaller than root, so it is set as the left child of root (5)
        // 3: smaller than root but greater than root left child (2), so set as right child of 2
        // 4: smaller than root, set as right child of 3
        // 6: greater than root, set as right child of root
        // 7: greater than root and than the right child (6), so set as the right child of 6
        // final visual representation of tree:
        //    |---- 5 ----|
        //    2 --|       6 --|
        //        3 --|       7
        //            4

//        // other example
        SearchTree otherTree = new SearchTree(null);

        String otherStringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] otherData = otherStringData.split(" ");
        for (String s : otherData) {
            otherTree.addItem(new Node(s));
        }

        // removing an element
        otherTree.removeItem(new Node("Adelaide"));

        otherTree.traverse(otherTree.getRoot());
    }

}
