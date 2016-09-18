package pl.com.clockworkgnome.sudgame.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.NPC;

public class LocationTest {
    
    Location mainLocation;
    Location northLocation;
    
    @Before
    public void initTest() {
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        Location southLocation = new Location("Third", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        mainLocation.addExit(Direction.S, southLocation);
        NPC ork = new NPC("ork");
        NPC secondOrk = new NPC("ork2");
        mainLocation.addNpc(ork);
        mainLocation.addNpc(secondOrk);
    }
  
    @Test
    public void testDescription() {
    
        String description = mainLocation.getDescription();
        String validDescription = "Short\nLong\nVisible exits: north, south\nork, ork2";
        Assert.assertEquals("Compare descritpion", validDescription, description);
    
    }
    
    @Test
    public void testGetNextLocation() {
        
        Location nextLoc = mainLocation.getNextLocation(Direction.N);
        Assert.assertEquals("Same object",northLocation,nextLoc);
        
        Location nullLoc = mainLocation.getNextLocation(Direction.E);
        Assert.assertNull("Non-existing location", nullLoc);
    }
    
    @Test
    public void testGetNPC() {
        
        NPC getOrk = mainLocation.getNPC("ork");
        Assert.assertEquals("Existing npc","ork",getOrk.getName());
        NPC getOrk2 = mainLocation.getNPC("ork4");
        Assert.assertNull("Non-existing npc",getOrk2);
    }
    
}
