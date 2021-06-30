package linkedlistplayground;

import java.util.Arrays;

public class LLPlayground {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("---------------------");

        list.add(1);
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(0));

        System.out.println("---------------------");

        list.add(2);
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(-1));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
//        System.out.println(list.getNode(0).next);
//        System.out.println(list.getNode(1).next);

        System.out.println("---------------------");
        list.add(3);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println("---------------------");
        list.add("a");
        list.add("b");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());

        System.out.println("---------------------");
        MyLinkedList newList = new MyLinkedList();
        newList.add(1);
        newList.add(2);
        System.out.println(newList.size());
        System.out.println(Arrays.toString(newList.toArray()));
        newList.set(0, 5);
        System.out.println(newList.size());
        System.out.println(Arrays.toString(newList.toArray()));
        newList.set(1, "a");
        System.out.println(newList.size());
//        System.out.println(newList.getNode(0).value);
//        System.out.println(newList.getNode(0).next);
//        System.out.println(newList.getNode(1).value);
//        System.out.println(newList.getNode(1).next);
//        System.out.println(newList.getNode(2));
//        System.out.println(newList.getNode(2).value);
//        System.out.println(newList.getNode(2).next);
//        System.out.println(newList.getNode(3).value);
//        System.out.println(newList.getNode(3).next);
//        System.out.println("first: " + newList.first);
//        System.out.println("last: " + newList.last);
        System.out.println(Arrays.toString(newList.toArray()));
        newList.set(3, "j");
        System.out.println(Arrays.toString(newList.toArray()));

        System.out.println(newList.indexOf(5));
        System.out.println(newList.indexOf("j"));
        System.out.println(newList.indexOf(2));

        newList.remove("a");
        System.out.println(newList.size());
        System.out.println(Arrays.toString(newList.toArray()));

        newList.remove(2);
        System.out.println(newList.size());
        System.out.println(Arrays.toString(newList.toArray()));


//        System.out.println("first: " + newList.getFirst().getValue());
//        System.out.println("last: " + newList.getLast().getValue());
        newList.add(3);
//        System.out.println(newList.getNode(2).value);
//        System.out.println(newList.getNode(2).next);
//        System.out.println("first: " + newList.getFirst().getValue());
//        System.out.println("last: " + newList.getLast().getValue());
        System.out.println(newList.size());
        System.out.println(Arrays.toString(newList.toArray()));





    }
}
