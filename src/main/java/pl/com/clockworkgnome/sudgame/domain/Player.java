package pl.com.clockworkgnome.sudgame.domain;

public class Player {
    
    private String name;
    private Location currentLocation;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public String getCurrentLocationDescription() {
        return this.currentLocation.getDescription();
    }

    public boolean move(String command) {
        Location nextLocation = this.currentLocation.getNextLocation(command);
        if(nextLocation!=null) {
            this.currentLocation = nextLocation;
            return true;
        } else {
            return false;
        }
    }
    
    
}
