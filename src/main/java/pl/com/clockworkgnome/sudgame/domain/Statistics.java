package pl.com.clockworkgnome.sudgame.domain;

public class Statistics {
    
    private int health;
    private int strength;
    private int agility;

    public Statistics(int health, int strength, int agility) {
       this.health = health;
       this.strength = strength;
       this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    
    
    
}
