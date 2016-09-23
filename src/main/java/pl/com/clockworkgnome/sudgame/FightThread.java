package pl.com.clockworkgnome.sudgame;

import java.util.List;
import java.util.Random;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;

/**
 *
 * @author Pawel
 */
public class FightThread implements Runnable {
    
    private Player player;
    private NPC targetNPC;
    FightStrategy fightStrategy;
    
    public FightThread(Player player, NPC targetNPC, FightStrategy fightStrategy) {
        this.player = player;
        this.targetNPC = targetNPC;
        this.fightStrategy = fightStrategy;
    }
    
    @Override
    public void run() {
        fightStrategy.fight(player,targetNPC);
    }
    
}
