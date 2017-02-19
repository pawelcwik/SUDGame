package pl.com.clockworkgnome.sudgame.services;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class LookCommandTest {
    
    private Location mainLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
    }
    
    @Test
    public void lookTest() {
        Player p = new Player("TestPlayer");
        p.setCurrentLocation(mainLocation);
        LookCommand look = new LookCommand(p);
        String result = look.execute();
        assertEquals(mainLocation.getDescription(), result);
    }
    
}
