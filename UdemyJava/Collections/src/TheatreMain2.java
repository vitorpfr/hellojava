import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreMain2 {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Sorry, seat is taken or doesn't exist");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Sorry, seat is taken or doesn't exist");
        }

        // this is a new array, but references the same Seat objects as the original one
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());

        // reminder: this only works because Theatre.Seat implements Comparable interface
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));

        // Collections.sort(priceSeats) would sort using the compareTo method on Seats class
        // another way is to provide a Comparator object, which receives two seats and compare them
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);

    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("-------------------------------------------");
    }
}
