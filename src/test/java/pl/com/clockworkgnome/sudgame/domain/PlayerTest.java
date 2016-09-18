package pl.com.clockworkgnome.sudgame.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class PlayerTest {
    
    Location mainLocation;
    Location northLocation;
   
    @Before
    public void initTest() {
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
    }
    
    @Test
    public void testPlayerMove() {
        Player player = new Player("Pawel");
        player.setCurrentLocation(mainLocation);
        player.move(Direction.N);
        Assert.assertEquals("Ruch, ta sama lokacja",northLocation,player.getCurrentLocation());
    }
}
