package binaryioexample;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    // static code is shared among all Locations objects
    // another option here is to make Locations a singleton (only one object running)
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    // this block of code reads the data stored as binary in locations.dat (using BufferedInputStream to buffer reads to memory, avoiding accessing the disk many times)
    static {

        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            // read first 2 numbers
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            // load index data into memory (to allow random access later)
            while(ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }

        } catch (IOException e) {
            System.out.println("IOException in static initializer: " + e.getMessage());
        }

        // old code commented - read content from locations.dat sequentially and loads it into memory
//        try (var locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//
//            while (!eof) {
//                try {
//                    var location = (Location) locFile.readObject();
//                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() + " exits");
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//
//        // invalid class exception will happen when serialversionUID is not provided, so classes uid do not match when reading binary data (deserialized class and assigned class)
//        } catch (InvalidClassException e) {
//            System.out.println("InvalidClassException " + e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println("ClassNotFoundException " + e.getMessage());
//        }
    }

    // Building the random access file based on data stored in-memory:
    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the location section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It goes from byte 8 to byte 1699)
    // 4. The final sectionof the file will contain the location records (the data). It will start at byte 1700

    // this commented code (main method) writes data into a random access file
//    public static void main(String[] args) throws IOException {
//        // this piece of code builds/writes the file which will be used for random access reads
//        try (var rao = new RandomAccessFile( "locations_rand.dat", "rwd")) {
//            // (1) first writes the number of locations to file
//            rao.writeInt(locations.size());
//
//            // (2) then it writes the size of the index section
//            // for each location we will store 3 integers (location id, offset for location, size/length of location record)
//            // so, we calculate the start of actual data by calculating the size of the whole index section
//            int indexSize = locations.size() * 3 * Integer.BYTES; // each location stores 3 integers here
//            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES); // this last byte accounts for this int being written in the next line
//            rao.writeInt(locationStart);
//
//            // (3) index section is skipped here because, while writing location data, we will accumulate index data in memory
//            // to write it all at once in the end
//            long indexStart = rao.getFilePointer();
//
//            // (4) next: actual data section
//            // for each location, write: locID, locDescription, write each direction and exit and update pointer to next
//            int startPointer = locationStart;
//            rao.seek(startPointer); // moves writer pointer to start of location data
//            for (Location loc : locations.values()) {
//                rao.writeInt(loc.getLocationID());
//                rao.writeUTF(loc.getDescription());
//                StringBuilder builder = new StringBuilder();
//                for (String direction : loc.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        // direction,locationID,direction,locationID (ex: N,1,U,2)
//                        builder.append(direction);
//                        builder.append(",");
//                        builder.append(loc.getExits().get(direction));
//                        builder.append(",");
//                    }
//                }
//
//                rao.writeUTF(builder.toString());
//                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
//                index.put(loc.getLocationID(), record);
//
//                startPointer = (int) rao.getFilePointer();
//            }
//
//            // (3) now actually writing index data
//            rao.seek(indexStart);
//            for (int locationID : index.keySet()) {
//                rao.writeInt(locationID); // add locID
//                rao.writeInt(index.get(locationID).getStartByte()); // add offset of this locID
//                rao.writeInt(index.get(locationID).getLength()); // add length of this locID
//            }
//        }
//    }

    // this method gets the location data from the random access file, builds the Location object and returns it
    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF(); // readUTF knows the length of string (how many bytes to read) because writeUTF writes the length of the string first
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description);

        if (locationId != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]); // increment i first, then grab element
                location.addExit(direction, destination);
            }
        }

        return location;
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

    public void close() throws IOException {
        ra.close();
    }
}
