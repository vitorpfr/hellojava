import java.util.*;

public class Theatre {
    private final String theatreName;

    // List<Seat> is already generic (ArrayList, LinkedList, all of them work)
    // but we can make it even more generic by using Collection<Seat> (Collection interface is above List interface)
    // https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
    private List<Seat> seats = new ArrayList<>(); // ArrayList, LinkedList, HashSet, LinkedHashSet, etc...

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        // loops through rows from A to last row letter
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {

            // loops through each "column" (seat) on this current row
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {

                // String.format formats seatNum with leading zero (01, 02, 03, ...)
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        // does a binary search to find the seatNumber (much more efficient than normal for loop)
        // this only works because Seat implements Comparable (so the search knows how to compare seats)
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        // if index was found, return it reserved. if not, return false
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }


//        // loop through seats
//        for (Seat seat : seats) {
//
//            // print a dot (so we can know how many seats it needed to pass through to find the selected seat
//            System.out.print(".");
//
//            // seat was found, so exit for loop
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // this is overriden, so the collection knows how to compare seats and order them properly
        // to make locating a seat easier (since elements will be "indexed")
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " canceled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
