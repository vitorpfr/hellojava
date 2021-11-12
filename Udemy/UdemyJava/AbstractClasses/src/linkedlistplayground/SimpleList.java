package linkedlistplayground;

public interface SimpleList {
    int size();
    boolean isEmpty();
    Object[] toArray();
    boolean contains(Object o);
    boolean add(Object o);
    boolean remove(Object o);
    int indexOf(Object o);
    Object get(int index);
    boolean set(int index, Object o);
}
