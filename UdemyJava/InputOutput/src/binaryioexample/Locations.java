package binaryioexample;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    // static code is shared among all Locations objects
    // another option here is to make Locations a singleton (only one object running)
    private static Map<Integer, Location> locations = new HashMap<>();

    // this block of code reads the data stored as binary in locations.dat (using BufferedInputStream to buffer reads to memory, avoiding accessing the disk many times)
    static {
        try (var locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;

            // read option 1: the code below reads binary data stored as "primitive" types (int, string, etc)
//            while (!eof) {
//                try {
//                    // read and insert location into memory
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    System.out.println("Read location " + locID + " : " + description);
//                    locations.put(locID, new Location(locID, description));
//
//                    // read and insert this location exits into memory
//                    int numExits = locFile.readInt();
//                    System.out.println("Found " + numExits + " exits");
//                    for (int i = 0; i < numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        locations.get(locID).addExit(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                } catch (EOFException e) {
//                    // mechanism to interrupt while loop when end of file is reached
//                    eof = true;
//                }
//            }

            // read option 2: if data is stored with ObjectOutputStream, you can read entire objects at once in the binary file (code becomes cleaner)
            while (!eof) {
                try {
                    var location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }

        // invalid class exception will happen when serialversionUID is not provided, so classes uid do not match when reading binary data (deserialized class and assigned class)
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }

//        // more modern version with bufferedreader (preferred method to minimize disk access)
//        try (var reader = new BufferedReader(new FileReader("locations_big.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String description = data[1];
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // more modern version: using try with resources
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                locations.get(loc).addExit(direction, destination);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws IOException {
//        // write option 1: writes binary data to location.dat
//        // important when writing binary data: have logging available of what's being written
//        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//            // for each location, add to file
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription()); // writeUTF writes a string
//                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
//
//                // for each exit of this location, write to file
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits."); // deducts one so quit exit is not recorded
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }

        // write option 2: writes data to locations.dat as an object output (writing entire objects as binary, instead of object primitive fields as binary)
        // code is much more simple because it writes entire object at once
        try (var locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
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
