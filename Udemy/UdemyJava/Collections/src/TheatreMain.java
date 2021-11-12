import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreMain {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        // prints all seats from A01 to H12
//        theatre.getSeats();

        System.out.println("RESERVATION: BRUTE-FORCE (TRAVERSE LIST) VS BINARY SEARCH");

        // testing reservation - brute force way
        theatre.inefficientReserveSeat("H12"); // should reserve successfully
        theatre.inefficientReserveSeat("H12"); // seat is already reserved
        theatre.inefficientReserveSeat("H15"); // seat doesn't exist

        // Collections class provides a binary search method, but item inside coll must implement Comparable
        // THIS ONLY WORKS AS-IS BECAUSE THE SEATS ARE CREATED ALREADY SORTED! IF NOT, SORTING BEFORE IS NECESSARY
        theatre.reserveSeat("H12"); // should reserve successfully
        theatre.reserveSeat("H12"); // seat is already reserved
        theatre.reserveSeat("H15"); // seat doesn't exist


        System.out.println("---------------------------------------");
        System.out.println("COLLECTIONS LIST METHODS");

        // min and max: returns min and max elements according to sort order (using compareTo method)
        System.out.println("min seat number is " + Collections.min(theatre.seats).getSeatNumber());
        System.out.println("max seat number is " + Collections.max(theatre.seats).getSeatNumber());

        // shallow copy (using constructor) - new list, but contents are the same objects (seats)
        // if we reserve a seat in one list, it will be reserved in the other list as well
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);
        System.out.println();
        seatCopy.get(1).reserve(); // reserved successfully
        theatre.reserveSeat("A02"); // already reserved!
        // to prove that they are separate lists, if we reverse one, other is not affected
        System.out.println("printing seatCopy, then original seats, after reversing seatCopy");
        Collections.reverse(seatCopy);
        printList(seatCopy);
        printList(theatre.seats);

        Collections.shuffle(seatCopy);
        sortList(seatCopy);
        System.out.println("Priting sorted seatCopy");
        printList(seatCopy);

        // Collections.copy requires the list to be initialized before

        // if I want to sort a collection by other field (e.g. price) I can instantiate a Comparator class and pass it to the sort method
        // Theatre.PRICE_ORDER here is a static field that instantiates a Comparator<Seat>, and returns 1, 0 and -1 according to price comparison
//        Collections.sort(seatCopy, Theatre.PRICE_ORDER);

        // important: the comparator must sort until it is consistent with equals
        // which means it will only return 0 if the seats are actually the same (so, to be right, if price is equal, it should check seat number)
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("==========================================================");
    }

    // variation of bubble sort method
    // slower than merge sort, but uses less memory
    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
