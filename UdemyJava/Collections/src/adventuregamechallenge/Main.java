package adventuregamechallenge;

/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private Map<String, String> vocabulary = new HashMap<>();

    public Main() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");
        vocabulary.put("N", "N");
        vocabulary.put("S", "S");
        vocabulary.put("E", "E");
        vocabulary.put("W", "W");
        vocabulary.put("Q", "Q");
    }

    public void command() {
        // initialize vars
        Scanner scanner = new Scanner(System.in);
        int loc = 1;

        while (true) {
            // print description of current location
            var currentLocation = locations.get(loc);
            System.out.println(currentLocation.getDescription());

            // if current location is 0 (quit), exit program
            if (loc == 0) {
                break;
            }

            // print exits available in current location
            var exits = currentLocation.getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            // get input from user of direction and clean it
            String userInput = scanner.nextLine();
            String[] userInputWords = userInput.split(" ");
            String cleanInput = "";
            for (String word : userInputWords) {
                String cleanWord = word.trim().toUpperCase();
                if (vocabulary.containsKey(cleanWord)) {
                    cleanInput = vocabulary.get(cleanWord);
                    break; // get first word that matches
                }
            }

            // if proposed exit is valid, get corresponding new location
            int newLoc = -1;
            if (exits.containsKey(cleanInput)) {
                newLoc = exits.get(cleanInput);
            }

            // if direction is invalid, alert user
            // otherwise, move to new location
            if (newLoc == -1) {
                System.out.println("You cannot go in that direction");
            } else {
                loc = newLoc;
            }
        }

    }

    public static void main(String[] args) {
        Main game = new Main();

        game.command();

//        int loc = 1;
//        while (true) {
//            System.out.println(game.locations.get(loc).getDescription());
//            if (loc == 0) {
//                break;
//            }
//
//            loc = scanner.nextInt();
//            if (!locations.containsKey(loc)) {
//                System.out.println("You cannot go in that direction");
//            }
//        }
    }
}