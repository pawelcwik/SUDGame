package pl.com.clockworkgnome.sudgame.domain;

import java.util.HashMap;
import java.util.Map;

public class Location {
    
    private String longDescription;
    private String shortDescription;
    private Map<String,Location> exit;

    public Location(String shortDescription, String longDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.exit = new HashMap<>();
    }

    public String getDescription() {
        return this.shortDescription + "\n" + this.longDescription;
    }
    
    public void addExit(String direction, Location location) {
        this.exit.put(direction, location);
    }

    public Location getNextLocation(String command) {
        boolean exists = this.exit.containsKey(command);
        if(exists) {
            return this.exit.get(command);
        } else {
            return null;
        }
    }

    
}
