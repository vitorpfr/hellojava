package linkedlistplayground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    @Test
    public void testLinkedlist() {
        // empty list
        MyLinkedList linkedList1 = new MyLinkedList();
        assertTrue(linkedList1.isEmpty());

        // list with one element added
        assertTrue(linkedList1.add(1));
        assertFalse(linkedList1.isEmpty());
        assertEquals(1, linkedList1.get(0));
        assertEquals(1, linkedList1.size());
        assertNull(linkedList1.get(-1));
        assertNull(linkedList1.get(1));

        // list with two elements added
        assertTrue(linkedList1.add(20));
        assertEquals(1, linkedList1.get(0));
        assertEquals(20, linkedList1.get(1));
        assertEquals(2, linkedList1.size());
        assertEquals(1, linkedList1.indexOf(20));
        assertEquals(-1, linkedList1.indexOf(45));

        // list with three elements added (two ints, one String)
        assertTrue(linkedList1.add("abc"));
        assertEquals("abc", linkedList1.get(2));
        assertEquals(3, linkedList1.size());
        assertArrayEquals(new Object[]{1, 20, "abc"}, linkedList1.toArray());
        assertTrue(linkedList1.contains("abc"));
        assertFalse(linkedList1.contains("abcd"));

        // list with four elements added, one using 'set' to a specific index
        assertTrue(linkedList1.set(0, -30));
        assertEquals(4, linkedList1.size());
        assertArrayEquals(new Object[]{-30, 1, 20, "abc"}, linkedList1.toArray());

        // list with three elements added, with one element previously removed
        assertTrue(linkedList1.remove(20));
        assertEquals(3, linkedList1.size());
        assertArrayEquals(new Object[]{-30, 1, "abc"}, linkedList1.toArray());
    }
}
