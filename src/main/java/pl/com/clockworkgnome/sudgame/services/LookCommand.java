package pl.com.clockworkgnome.sudgame.services;

import org.junit.Before;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class LookCommand implements Command {
    
    private Player player;

    public LookCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        return player.getCurrentLocationDescription();
    }
    
}
