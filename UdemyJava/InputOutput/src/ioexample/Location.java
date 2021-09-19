package ioexample;
import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

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

