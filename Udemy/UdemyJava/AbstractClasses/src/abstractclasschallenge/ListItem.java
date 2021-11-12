package abstractclasschallenge;

public abstract class ListItem {
    protected ListItem leftLink = null;
    protected ListItem rightLink = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract int compareTo(ListItem item);

    protected Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

}
