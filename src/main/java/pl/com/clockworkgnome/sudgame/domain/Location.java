package pl.com.clockworkgnome.sudgame.domain;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Collections;
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
                +"\n"+ Joiner.on(", ").join(this.npcs);
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
        List<Direction> locationExits = new ArrayList<>(exit.keySet());
        Collections.sort(locationExits);    
        return Joiner.on(", ").join(locationExits);
    }
    
    public void addNpc(NPC npc) {
        this.npcs.add(npc);
    }

    public boolean isThereNPC(String npcName) {
        for(NPC npc : this.npcs) {
            if(npc.getName().equalsIgnoreCase(npcName)) {
                return true;
            }
        }
        return false;
    }

    public NPC getNPC(String npcName) {
        for(NPC npc : this.npcs) {
            if(npc.getName().equalsIgnoreCase(npcName)) {
                return npc;
            }
        }
        return null;
    }

    
}
