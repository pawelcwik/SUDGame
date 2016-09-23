package pl.com.clockworkgnome.sudgame;

import java.util.Scanner;
import pl.com.clockworkgnome.sudgame.domain.Player;
import pl.com.clockworkgnome.sudgame.repository.LocationRepository;
import pl.com.clockworkgnome.sudgame.services.CommandParser;

public class Main {
    
    public static void main(String[] args) {
        
        
        LocationRepository locationRepository = new LocationRepository();
        CommandParser parser = new CommandParser();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();
        
        Player player = new Player(playerName, 100, 10, 20);
        
        player.setCurrentLocation(locationRepository.getStartLocation());
        
        System.out.println(player.getCurrentLocationDescription());
        
        String command = "";
        while(!command.equals("quit")) {
            command = readPlayerInput(scanner);
            parser.actOnCommand(command,player);
        }
        
        System.out.println("Goodbye!");
    }

    private static String readPlayerInput(Scanner scanner) {
       System.out.print(">");
       String command = scanner.nextLine();
       return command;
    } 
}
