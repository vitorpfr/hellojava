import java.util.ArrayList;

public class LinkedLists {
    // ARRAY LIST
    // array list is an indexed collection of items (items are referenced by their index)

    // e.g. when creating an array of ints, each int occupies 4 bytes in memory (32 bits).
    // so, since they are sequential in memory, if I know the address of the element 0 (x), address of element 2 is (x + (3*4) - 12 bytes after

    // however, this doesn't work for objects and strings, because each string/object has a different memory size!
    // what Java does internally is to allocate 8 bytes for each ADDRESS, and the address points to the real string/object location in memory
    // so, even though objects/strings are all over the memory, when you 'for' loop, they are printed in the correct order (because their addresses are ordered in the array allocated memory)

    // those objects/strings all over the memory are cleaned by the JVM garbage collector when they're not referenced anymore

    // LINKED LIST
    // linked list is another type of list, where

    public static void main(String[] args) {

        // Creates one object
        Customer customer = new Customer("Tim", 54.96);

        // Creates a variable that points to the same object above
        Customer anotherCustomer;
        anotherCustomer = customer;

        // This changes the balance of the customer object, because 'anotherCustomer' points to 'customer' address
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance()); // 12.18


        // Creates array list and add elements
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        // adds element 2 in position 1
        // this line DO NOT override the number 3! instead, 3 and 4 are moved one position down!
        intList.add(1, 2);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        // this re-indexing of elements is quick for small lists, but can be really slow for large lists

        // LINKED LIST
        // an alternative to arrays; where each element stores a link to the next element
        // arraylist: for primitives, elements are stores sequentially in memory, for strings/objects addresses of elements are stored sequentially in memory, looping just goes through the elements/addresses
        // linkedlist: elements are stored in any memory place, and each element has within itself the address of the next element

        // immediate advantage of linkedlist: inserting or removing elements in the middle of the list is much much easier!
        // no need to move elements physically in memory: just point the anterior element to the new one, and the new one to the posterior element
    }
}
