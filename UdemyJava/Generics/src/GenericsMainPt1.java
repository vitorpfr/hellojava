import java.util.ArrayList;

public class GenericsMainPt1 {
    public static void main(String[] args) {
        // starting an arraylist that doesn't use generics (can contain objects of any type)
//        ArrayList items = new ArrayList();

        // these lines use autoboxing automatically (1 is converted to Integer.valueOf(1) for example), since ArrayList receives objects
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add("tim");   // this line is compiled normally
//        items.add(4);
//        items.add(5);
//
//        printDoubled(items);

        // stating an arraylist that use generics
        ArrayList<Integer> items = new ArrayList<>();

        items.add(1);
        items.add(2);
        items.add(3);
//        items.add("tim"); // now this line will prevent compiling and raise issue before project is ran
        items.add(4);
        items.add(5);

        printDoubled(items);

    }

    private static void printDoubled(ArrayList<Integer> n) {
        // since the type is not specified in the arraylist, we need to loop through Objects and cast value to Integer
        // however, it raises an exception when it gets to the string "tim" that was added!
//
//        for (Object i : n) {
//            System.out.println((Integer) i * 2);
//        }

        // the main issue here is not the exception, but that the program is compiling normally, and only breaks at runtime

        // up until Java 1.5, this was the default way to use ArrayList, but it has issues. After that, we can use generics!
        // old code (using raw class without generics) works just for backward compatibility, but you shouldn't use it!

        // summary: when declaring ArrayList, always use parametrized type!

        // now doing it right, with an ArrayList with the type
        for (int i : n) { // it is actually Integer, but Java does the autoboxing/unboxing automatically
            System.out.println(i * 2);
        }
    }


}
