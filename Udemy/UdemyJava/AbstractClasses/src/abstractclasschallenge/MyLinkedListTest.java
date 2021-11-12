package abstractclasschallenge;

public class MyLinkedListTest {
    public static void main(String[] args) {
        // starts list with node 50, which has right and left link set to null
        MyLinkedList list = new MyLinkedList(new Node(50));
        // adds a new node with value 60;
        // compareTo returns 1, so the node should be added in the right
        list.addItem(new Node(60));

        // adds a new node with the value 70
        // compareTo returns 1 until next is null, so the node should be added in the extreme right
        list.addItem(new Node(70));
        list.addItem(new Node(60)); // doesn't do anything

        // adds a new node with the value 55
        // compareTo returns 1, but the next compareTo returns -1, new node should be root's next node, and it should have 60 as the next node
        list.addItem(new Node(55));

        list.addItem(new Node(30));
        list.addItem(new Node(20));
        list.addItem(new Node(40));

        list.traverse(list.getRoot());

        MyLinkedList strList = new MyLinkedList(new Node(null));
        strList.addItem(new Node("d"));
        strList.addItem(new Node("f"));
        strList.addItem(new Node("g"));
        strList.addItem(new Node("e"));
        strList.addItem(new Node("c"));
        strList.addItem(new Node("a"));
        strList.addItem(new Node("b"));
        strList.addItem(new Node("c"));
        strList.traverse(strList.getRoot());


    }
}
