package pl.com.clockworkgnome.sudgame.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;


public class CommandParserTest {
    
    Location mainLocation;
    Location northLocation;
   
    @Before
    public void initTest() {
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addExit(Direction.N, northLocation);
        NPC ork = new NPC("ork");
        mainLocation.addNpc(ork);
    }
    
    @Test
    public void testParserMove() {
        
        Player dummyPlayer = new Player("P");
        CommandParser parser = new CommandParser();
        CommandParser spyParser = Mockito.spy(parser);
        dummyPlayer.setCurrentLocation(mainLocation);
        spyParser.actOnCommand("north", dummyPlayer);
        Mockito.verify(spyParser, times(1)).move(Direction.N,dummyPlayer);
        
    }
    
     @Test
    public void testParserKill() {
        
        Player dummyPlayer = new Player("P");
        CommandParser parser = new CommandParser();
        CommandParser spyParser = Mockito.spy(parser);
        dummyPlayer.setCurrentLocation(mainLocation);
        spyParser.actOnCommand("kill ork", dummyPlayer);
        Mockito.verify(spyParser, times(1)).attack("ork", dummyPlayer);
        
    }
}
