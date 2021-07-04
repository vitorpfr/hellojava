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
    }
}
