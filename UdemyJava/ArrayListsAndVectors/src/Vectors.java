import java.util.List;
import java.util.Vector;

public class Vectors {

    // ArrayList is very similar to Vector

    // differences:
    // ArrayList: ArrayList methods are not synchronized (which means it is not thread-safe - if multiple threads are accessing the same list, issues may happen)
    // Vector: vector methods are synchronized (thread-safe), but are costlier

    // summary: if there's no need for thread safety (e.g. running one thread only), always use ArrayList (less costly), otherwise use Vector

    // both implement the List interface, so they can be used interchangeably if the variable is declared as a List

    public static void main(String[] args) {
        List<String> myList = new Vector<>(); // could be ArrayList as well

        // methods are identical to ArrayList
        myList.add("a");
        myList.add("b");

        System.out.println(myList.toString());




    }
}
