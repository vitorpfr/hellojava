public class StringBuilderAndStringBuffer {

    // both StringBuilder and StringBuffer are mutable Strings (as opposed to String which is immutable)
    // but StringBuilder is not thread-safe and StringBuffer is

    // if thread safety is not an issue, prefer using StringBuilder because it is faster!
    // this guide will focus on StringBuilder for this reason

    // OBS: This content is not in the Java Udemy course!

    public static void main(String[] args) {
        // StringBuilder
        // The StringBuilder in Java represents a mutable sequence of characters.

        // ways to initialize a stringbuilder
        StringBuilder sb1 = new StringBuilder(); // default of 16 characters as capacity
        StringBuilder sb2 = new StringBuilder(5);
        StringBuilder sb3 = new StringBuilder("abc");

        // add data
        sb1.append("abc");

        // print (.toString is redundant)
        System.out.println(sb1.toString());

        // see capacity
        System.out.println(sb1.capacity());

        // add beyond capacity - capacity is adjusted automatically
        sb1.append("defghijklmnopqrstuvwxyz");
        System.out.println(sb1);
        System.out.println(sb1.capacity());

        // get substring (includes first, excludes last)
        System.out.println(sb1.substring(5, 8));

        // delete substring
        sb1.delete(5, 8);
        System.out.println(sb1);

        // get char at a index
        System.out.println(sb1.charAt(1));

        // get index of a substring
        System.out.println(sb1.indexOf("tuv"));

        // reverse string
        sb1.reverse();
        System.out.println(sb1);
    }
}
