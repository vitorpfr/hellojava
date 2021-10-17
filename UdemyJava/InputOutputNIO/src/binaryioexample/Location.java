package binaryioexample;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// when storing/reading binary data to a file, we can either store primitive by primitive and re-instantiate objects one per time, or we can store objects itself and read them
// to store objects, their class must implement Serializable
// furthermore, all their fields must be from types/classes that implement Serializable, and the class itself needs to have a private long serialVersionUID
// this serialversion is used to check if the stored object class matches the class which it is being assigned to when it is read
public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    // read explanation above!
    // if this line is commented, reading objects from binary files will throw exception
    private long serialVersionUID = 1L;

    // to make the location immutable, ideally the exits should be received by the constructor and the function
    // and the function addExit should be removed
    // in this case, this.exits should be a new HashMap(receivedExits)
    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
        this.exits.put("Q", 0);
    }

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}

