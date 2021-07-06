import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreMain {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();

        // first time: reserves the seat
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        // second time: seat is already taken
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        // now trying to reserve seat with different types of collections
        // ArrayList with brute force for loop: passes through all elements, very inefficient - kind of a brute force
        // ArrayList with binary search: much more efficient, but it needs the Class inside it (Seat in this case) to implement Comparable

        // everything below here doesn't work because Seat and seats are not public anymore
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
        printList(seatCopy);

        // copying the ArrayList with the constructor makes a shallow copy
        // I reserve one seat, seatCopy will also be changed (arrayLists have address of same Seat objects)
        seatCopy.get(1).reserve();

        // this prints "Seat already reserved" because it was already done done in the array copy
        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        // if I reverse one of the, the other is not reversed!
        // this proves that seatCopy and theatre.seats are separate ArrayLists, but they contain references to the same Seat objects
        Collections.shuffle(seatCopy); // or Collections.reverse
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seats");
//        printList(theatre.getSeats());

        // Collections methods to get min and max element of a collection (element class needs to have Comparable interface implemented)
        // it iterates through entire collection: O(n)
        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber() + " and max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        List<Theatre.Seat> newList = new ArrayList<>(theatre.getSeats().size());
//        Collections.copy(newList, theatre.seats); // doesn't work because it needs an initialized list with elements alerady there, and new ArrayList hasn't done it yet
        // in summary, Collections.copy is not very useful to create a deep copy of an existing list
        // ref: https://stackoverflow.com/questions/1330288/how-to-make-a-separated-copy-of-an-arraylist
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("-------------------------------------------");
    }

    // this is a variation of bubble sort, which swaps close elements
    // not as efficient as the built-in merge sort, but uses less memory, so it may useful when memory is a concern
    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < (list.size() - 1); i++) {
            for (int j = (i + 1); j < list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
