/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.clockworkgnome.sudgame;

import pl.com.clockworkgnome.sudgame.domain.NPC;
import pl.com.clockworkgnome.sudgame.domain.Player;

/**
 *
 * @author Pawel
 */
public interface FightStrategy {

    public void fight(Player player, NPC targetNPC);
    
}
