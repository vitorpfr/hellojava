package adventuregame;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }


    // this method returns a new map (copy) of the exits map, with all its mappings, instead of returning the exits map itself
    // reason: making sure nothing outside of the class can change exits
    // if the caller program adds or removes fields from this return, we guarantee that the exits field is not affected
    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
