package pl.com.clockworkgnome.sudgame.domain;

public class Player {
    
    private String name;
    private Location currentLocation;
    
    private int health;
    private int strength;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.strength = 5;
    }

    public Player(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }
    
    public Location getCurrentLocation() {
        return this.currentLocation;
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

    public boolean move(Direction direction) {
        Location nextLocation = this.currentLocation.getNextLocation(direction);
        if(nextLocation!=null) {
            this.currentLocation = nextLocation;
            return true;
        } else {
            return false;
        }
    }

    public NPC getNearbyNPC(String npcName) {
        return this.currentLocation.getNPC(npcName);
    }

    public boolean isAlive() {
        return health>0;
    }

    public int getStrength() {
        return strength;
    }

    public void damageTaken(int hit) {
        this.health = this.health - hit;
    }

    public boolean isThereNPCNearby(NPC targetNPC) {
        return this.currentLocation.isThereNPC(targetNPC.getName());
    }
    
    
    
    
}
