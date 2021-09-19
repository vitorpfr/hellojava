package binaryioexample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private Map<String, String> vocabulary = new HashMap<>();

    public Main() {
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
//        int loc = 1;
        int loc = 64;

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
    }
}
