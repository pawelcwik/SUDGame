package pl.com.clockworkgnome.sudgame;

import java.util.Random;
import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class AgilityFightStrategy implements FightStrategy {
    
    
    @Override
    public void fight(Player player, NPC targetNPC) {
        int hit=0;
        while(player.isAlive() && targetNPC.isAlive()) {
            
            boolean targetStillHere = player.isThereNPCNearby(targetNPC);
            
            if(!targetStillHere) {
                System.out.println("Your target is no longer here.");
                return;
            }
            
            try {
                if(calculateHitChance(player, targetNPC)) {
                    hit = calculateHitStrength(player.getStrength());
                    showHitMessage(targetNPC,hit);
                    targetNPC.damageTaken(hit);
                } else {
                    System.out.println("Your hit misses " + targetNPC.getName());
                }
                
                Thread.sleep(2000);
                
                if(calculateHitChance(targetNPC, player)) {
                    hit = calculateHitStrength(targetNPC.getStrength());
                    showHitMessage(hit);
                    player.damageTaken(hit);
                } else {
                    System.out.println(targetNPC.getName() +"'s hit misses you" );
                }
                
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Caly terror rozpetal error");
            }
        }
        
        if(player.isAlive() && !targetNPC.isAlive()) {
            System.out.println("You are victorious!");
        } else if((!player.isAlive() && targetNPC.isAlive())) {
            System.out.println("Try harder next time");
        } else {
            System.out.println("Run away!");
        }
    }
    
    private int calculateHitStrength(int strength) {
        Random r = new Random();
        return strength + r.nextInt(4);
    }

    private void showHitMessage(NPC targetNPC, int hit) {
        System.out.println("You hit " + targetNPC.getName() + " for " + hit + " damage.");
    }

    private void showHitMessage(int hit) {
        System.out.println("You're hit for " + hit + " damage.");
    }

    private boolean calculateHitChance(NPC targetNPC, Player player) {
        int rand = new Random().nextInt(20);
        return (targetNPC.getAgility()+rand)>player.getAgility();
    }
    
    private boolean calculateHitChance(Player player, NPC targetNPC) {
        int rand = new Random().nextInt(40);
        return (player.getAgility()+rand)>targetNPC.getAgility();
    }
    
}
