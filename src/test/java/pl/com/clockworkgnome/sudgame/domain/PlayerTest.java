package pl.com.clockworkgnome.sudgame.domain;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    
    Location mainLocation;
    Location northLocation;
   
    @Before
    public void initTest() {
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
    }
}
