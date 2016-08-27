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

    
}
