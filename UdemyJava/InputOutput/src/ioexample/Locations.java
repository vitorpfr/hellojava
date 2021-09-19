package ioexample;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    // static code is shared among all Locations objects
    // another option here is to make Locations a singleton (only one object running)
    private static Map<Integer, Location> locations = new HashMap<>();
    static {
        // manual data input:
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
//        locations.put(2, new Location(2, "You are at the top of a hill"));
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
//        locations.put(4, new Location(4, "You are in a valley beside a stream"));
//        locations.put(5, new Location(5, "You are in the forest"));
//
//        locations.get(1).addExit("W", 2);
//        locations.get(1).addExit("E", 3);
//        locations.get(1).addExit("S", 4);
//        locations.get(1).addExit("N", 5);
//
//        locations.get(2).addExit("N", 5);
//
//        locations.get(3).addExit("W", 1);
//
//        locations.get(4).addExit("N", 1);
//        locations.get(4).addExit("W", 2);
//
//        locations.get(5).addExit("S", 1);
//        locations.get(5).addExit("W", 2);

        // instead of manually inputting data, now we will read from a local file
        // reading location using the FileReader only (default method, reads one character at a time)
        // older java option: using try/finally
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("locations_big.txt"));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description));
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                // we don't need to close the filereader because scanner.close() already closes if the readable implements Closeable
//                scanner.close();
//            }
//        }

        // more modern version: using try with resources
//        try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // more modern version with bufferedreader (preferred method to minimize disk access)
        try (var reader = new BufferedReader(new FileReader("locations_big.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(loc, new Location(loc, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // reading the directions using BufferedReader (reads more characters at once and buffers in an array
        // it is more efficient because saves "hops" to the file
        // older java option: using try/finally
//        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                // one way to do it: getting piece by piece
////                int loc = scanner.nextInt();
////                scanner.skip(scanner.delimiter());
////                String direction = scanner.next();
////                scanner.skip(scanner.delimiter());
////                String dest = scanner.nextLine();
////                int destination = Integer.parseInt(dest);
//                // another way to load data: using split
//                String input = scanner.nextLine();
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                locations.get(loc).addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }

        // more modern version: using try with resources
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                locations.get(loc).addExit(direction, destination);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        // issue: if for loop crashes, locFile stream will not be closed!
//        // solution: use a finally block to close stream (it is executed always, regardless of try/catch result)
//        // in this case, try/finally block is used to ensure the file will be closed regardless of exceptions
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        }
//        // this block is not necessary if you specify that this method throws IOException
////        catch (IOException e) {
////            System.out.println("In catch block");
////            e.printStackTrace(); }
//        finally {
//            System.out.println("In finally block");
//            // this prevents nullpointerexception: if file was not created, do not try to close it!
//            if (locFile != null) {
//                System.out.println("Attempting to close locfile");
//                // failing to close file can cause memory leak or the file can remain locked
//                locFile.close();
//            }
//        }

        // another approach: try with resources (added on recent java versions), resulting code is cleaner
        // it doesn't need finally block because try with resources automatically ensures stream is closed
//        try (FileWriter locFile = new FileWriter("locations.txt");
//             FileWriter dirFile = new FileWriter("directions.txt")) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                }
//            }
//        }

        // preferred method: try with resources + bufferedwriter (to avoid disk access, which is expensive)
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations_out.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions_out.txt"))) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
