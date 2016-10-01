package pl.com.clockworkgnome.sudgame.services;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;
import static junit.framework.Assert.assertEquals;


public class MoveCommandTest {
    
    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        NPC ork = new NPC("ork");
        mainLocation.addNpc(ork);
    }
    
    @Test
    public void moveIfProperDirectionIsSend() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.N,p);
        String result = move.execute();
        assertEquals(northLocation.getDescription(),result);
    }
    
    @Test
    public void returnInfoIfThereIsNoLocationInGivenDirection() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.S, p);
        String result = move.execute();
        assertEquals("You can't go that way.", result);
    }
    
}
