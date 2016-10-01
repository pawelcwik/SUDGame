package pl.com.clockworkgnome.sudgame.services;

import pl.com.clockworkgnome.sudgame.AgilityFightStrategy;
import pl.com.clockworkgnome.sudgame.FightStrategy;
import pl.com.clockworkgnome.sudgame.FightThread;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class KillCommand implements Command{
    
    private String targetName;
    private Player player;

    KillCommand(String targetName, Player player) {
        this.targetName = targetName;
        this.player = player;
    }

    @Override
    public String execute() {
        
        String result = "";
        
        NPC targetNPC = player.getNearbyNPC(targetName);
        if (targetNPC != null) {
            result = "You are charging " + targetName;
            beginCombat(player, targetNPC);
        } else {
            result = "There's no one like that around.";
        }
        
        return result;
    }
    
    void beginCombat(Player player, NPC targetNPC) {

        FightStrategy fs = new AgilityFightStrategy();

        FightThread ft = new FightThread(player, targetNPC, fs);
        Thread t = new Thread(ft);

        t.start();
    }
    
}
