package pl.com.clockworkgnome.sudgame;

import java.util.Scanner;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class Main {
    
    public static void main(String[] args) {
        
        String playerName = askPlayerAboutName();
        
        Player player = new Player(playerName);
        Location startLoc = new Location("Small room","You're in small, dark room. Single bed standing next to the wall is only furniture in here.");
        
        player.setCurrentLocation(startLoc);
        
        System.out.println(player.getCurrentLocationDescription());
    }

    private static String askPlayerAboutName() {
       System.out.println("What's your name?");
       Scanner scanner = new Scanner(System.in);
       String name = scanner.nextLine();
       System.out.println("\n Hello " + name + "\n");
       scanner.close();
       return name;
    }
}
