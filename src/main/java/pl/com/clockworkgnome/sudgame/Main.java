package pl.com.clockworkgnome.sudgame;

import java.util.Scanner;
import pl.com.clockworkgnome.sudgame.domain.Direction;
import pl.com.clockworkgnome.sudgame.domain.Location;
import pl.com.clockworkgnome.sudgame.domain.Player;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();
        
        Player player = new Player(playerName);
        Location startLoc = new Location("Small room","You're in small, dark room. Single bed standing next to the wall is only furniture in here.");
        Location secondLocation = new Location("Dark corridor","In dim, flickering lights you're not able to see much. Narrow space of the corridor is surrounded by steel walls.");
        
        startLoc.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S,startLoc);
        
        player.setCurrentLocation(startLoc);
        
        System.out.println(player.getCurrentLocationDescription());
        
        String command = "";
        while(!command.equals("quit")) {
            command = readPlayerInput(scanner);
            actOnCommand(command,player);
        }
        
        System.out.println("Goodbye!");
    }

    private static String readPlayerInput(Scanner scanner) {
       System.out.print(">");
       String command = scanner.nextLine();
       return command;
    }

    private static void actOnCommand(String command, Player player) {
       
        switch (command) {
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
            default: 
                System.out.println("Unknown command.");
                break;
        }
    }

    private static void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if(hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("You can't go that way.");
        }
    }
}
