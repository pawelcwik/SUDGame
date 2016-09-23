package pl.com.clockworkgnome.sudgame.services;

import pl.com.clockworkgnome.sudgame.AgilityFightStrategy;
import pl.com.clockworkgnome.sudgame.ClassicFightStrategy;
import pl.com.clockworkgnome.sudgame.FightStrategy;
import pl.com.clockworkgnome.sudgame.FightThread;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class CommandParser {

    public void actOnCommand(String command, Player player) {
        command = command.toLowerCase();

        String[] splitted = command.split(" ");

        switch (splitted[0]) {
            case "n":
            case "north":
                move(Direction.N, player);
                break;
            case "s":
            case "south":
                move(Direction.S, player);
                break;
            case "e":
            case "east":
                move(Direction.E, player);
                break;
            case "w":
            case "west":
                move(Direction.W, player);
                break;
            case "kill":
                attack(splitted[1], player);
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }

    void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("You can't go that way.");
        }
    }

    void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if (target != null) {
            beginCombat(player, targetNPC);
        } else {
            System.out.println("There's no one like that around.");
        }
    }

    private void beginCombat(Player player, NPC targetNPC) {
        
        FightStrategy fs = new AgilityFightStrategy();

        FightThread ft = new FightThread(player, targetNPC, fs);
        Thread t = new Thread(ft);

        t.start();
    }
}
