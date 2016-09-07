package pl.com.clockworkgnome.sudgame.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    
    private String longDescription;
    private String shortDescription;
    private Map<Direction,Location> exit;
    private List<NPC> npcs;

    public Location(String shortDescription, String longDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.exit = new HashMap<>();
        this.npcs = new ArrayList<>();
    }

    public String getDescription() {
        return this.shortDescription + "\n" + this.longDescription 
                +"\n"+"Visible exits: " + getExitString()
                +"\n"+ getNPCString();
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
    
    public void addNpc(NPC npc) {
        this.npcs.add(npc);
    }

    private String getNPCString() {
       String result = "";
       for(NPC npc : this.npcs) {
           result = result + npc.getName() + " ";
       }
       return result;
    }

    boolean isThereNPC(String npcName) {
        for(NPC npc : this.npcs) {
            if(npc.getName().equalsIgnoreCase(npcName)) {
                return true;
            }
        }
        return false;
    }

    NPC getNPC(String npcName) {
        for(NPC npc : this.npcs) {
            if(npc.getName().equalsIgnoreCase(npcName)) {
                return npc;
            }
        }
        return null;
    }

    
}
