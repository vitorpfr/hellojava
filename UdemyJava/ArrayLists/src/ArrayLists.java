import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLists {

    public static void main(String[] args) {
        // create array list
        ArrayList<String> myList = new ArrayList<>();

        // add element
        myList.add("abc");
        myList.add("def");
        myList.add("ghi");

        // check content
        System.out.println(myList.toString());

        // get index of element (returns -1 if not found)
        System.out.println(myList.indexOf("def"));

        // get element by index
        System.out.println(myList.get(1));

        // remove element
        myList.remove("def");
        System.out.println(myList.toString());

        // duplicate arraylist
        ArrayList<String> myOtherList = new ArrayList<>(myList);
        System.out.println(myOtherList.toString());

        ArrayList<String> mySecondOtherList = new ArrayList<>();
        mySecondOtherList.addAll(myList);
        System.out.println(mySecondOtherList.toString());


        // convert arraylist of strings (ArrayList<String>) to regular array of strings (String[])
        String[] myArray = new String[myList.size()];
        myArray = myList.toArray(myArray);
        System.out.println(Arrays.toString(myArray)); // same content as the ArrayLists

    }
}
