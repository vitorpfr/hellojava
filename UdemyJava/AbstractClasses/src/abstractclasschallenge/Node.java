package abstractclasschallenge;

public class Node extends ListItem {

    public Node(Object o) {
        super(o);
    }

    @Override
    protected ListItem previous() {
        return leftLink;
    }

    @Override
    protected ListItem setPrevious(ListItem item) {
        leftLink = item;
        return leftLink;
    }

    @Override
    protected ListItem next() {
        return rightLink;
    }

    @Override
    protected ListItem setNext(ListItem item) {
        rightLink = item;
        return rightLink;
    }

    @Override
    protected int compareTo(ListItem item) {
        if (item != null) {
            return value.toString().compareTo(item.getValue().toString());
        } else {
            return -1;
        }
    }
}
