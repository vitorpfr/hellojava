import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // create linked list
        LinkedList<String> placesToVisit = new LinkedList<>();

        // add elements
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");

        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        // adding an element in the middle of the list
        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        // iterator: a way to iterate through a list elements, equivalent to the for loop
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("-------------------------");
    }

    // issue: method both returns a value and has side effects in the linked list argument (using .next())
    // this should generally be avoided: if function returns value, it shouldn't modify object that it is called from
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        // list iterator is more flexible than a traditional iterator
        // when the first .next() is called, it will point to the first list element
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {

            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            }

            else if (comparison > 0) {
                // new City should appear before this one (e.g. Brisbane is the current element --> Adelaide is the newCit)

                // needs to use previous here because .next() already moved to the next register after Brisbane
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }

            else {
                // move on to the next city
                // action has already been done by .next()
            }
        }

        // if the loop went through the entire list without adding, we just add the element in the end of the list here
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;

                case 1:
                    // this is needed because change in direction needs to call the .next() two times to work
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                // This is possible because linkedList in Java is implemented in a way that a node knows the next and the previous node
                case 2:
                    // this is needed because change in direction needs to call the .previous() two times to work
                    if(goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city \n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
}
