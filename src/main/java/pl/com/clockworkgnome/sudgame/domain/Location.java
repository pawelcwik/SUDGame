package pl.com.clockworkgnome.sudgame.domain;

import java.util.HashMap;
import java.util.Map;

public class Location {
    
    private String longDescription;
    private String shortDescription;
    private Map<Direction,Location> exit;

    public Location(String shortDescription, String longDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.exit = new HashMap<>();
    }

    public String getDescription() {
        return this.shortDescription + "\n" + this.longDescription +"\n"+"Visible exits: " + getExitString();
    }
    
    public void addExit(Direction direction, Location location) {
        this.exit.put(direction, location);
    }

    public Location getNextLocation(Direction direction) {
        boolean exists = this.exit.containsKey(direction);
        if(exists) {
            return this.exit.get(direction);
        } else {
            return null;
        }
    }

    private String getExitString() {
        String exitsString = "";
        for(Direction direction : exit.keySet()) {
            exitsString+=direction.getDirectionDescription() + " ";
        }
        return exitsString;
    }

    
}
