package linkedlistplayground;


public class MyLinkedList implements SimpleList {
    private int size;
    private Node first;
    private Node last;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    private void addAsLast(Object o) {
        Node node = new Node(o, null);

        if (first == null) {
            first = node;
        }

        if (last != null) {
            last.next = node;
        }
        last = node;

        size++;
    }

    private Node getNode(int index) {
        Node n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    private Node getPreviousNode(int index) {
        return getNode(index - 1);
    }

    private Node getNextNode(int index) {
        return getNode(index + 1);
    }

    private boolean isIndexOutOfBounds(int index) {
        return ((index < 0) || (index >= size));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        addAsLast(o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int objectIndex = indexOf(o);

        if (objectIndex == -1) {
            return false;
        }

        return remove(objectIndex);
    }

    private boolean remove(int index) {
        if (isIndexOutOfBounds(index) || size == 0) {
            return false;
        }

        Node previousNode = getPreviousNode(index);
        Node nextNode = getNextNode(index);

        if (first.next == null) {
            first = null;
            last = null;
        } else {
            previousNode.next = nextNode;
            if (index == 0) {
                first = nextNode;
            }
            if (index == (size - 1)) {
                last = previousNode;
            }
        }

        size--;
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return array;
    }


    @Override
    public Object get(int index) {
        if (isIndexOutOfBounds(index)) {
            return null;
        }

        return getNode(index).value;
    }

    @Override
    public boolean set(int index, Object o) {
        if (isIndexOutOfBounds(index)) {
            return false;
        }

        Node node = getNode(index);
        Node newNode = new Node(o, node);

        if (index == 0) {
            first = newNode;
        } else {
            Node previousNode = getPreviousNode(index);
            previousNode.next = newNode;

            if (index == (size - 1)) {
                last = node;
            }
        }

        size++;
        return true;
    }

    @Override
    public int indexOf(Object o) {
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            if (o.equals(currentNode.value)) {
                return i;
            }
            currentNode = currentNode.next;
        }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return (indexOf(o) != -1);
    }

    private static class Node {
        private final Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
