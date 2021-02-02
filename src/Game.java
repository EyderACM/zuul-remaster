
import java.util.HashMap;

public class Game {

    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        HashMap<RoomDirections, Room> outsideExits = new HashMap<>();       
        outsideExits.put(RoomDirections.EAST, theatre);
        outsideExits.put(RoomDirections.SOUTH, lab);
        outsideExits.put(RoomDirections.WEST, pub);
        outside.setRoomExits(outsideExits);
        
        HashMap<RoomDirections, Room> theatreExits = new HashMap<>();        
        theatreExits.put(RoomDirections.WEST, outside);
        theatre.setRoomExits(theatreExits);
        
        HashMap<RoomDirections, Room> pubExits = new HashMap<>();        
        pubExits.put(RoomDirections.EAST, outside);        
        pub.setRoomExits(pubExits);
        
        HashMap<RoomDirections, Room> labExits = new HashMap<>();
        labExits.put(RoomDirections.NORTH, outside);
        labExits.put(RoomDirections.EAST, office);        
        lab.setRoomExits(labExits);
        
        HashMap<RoomDirections, Room> officeExits = new HashMap<>();        
        officeExits.put(RoomDirections.WEST, lab);
        office.setRoomExits(officeExits);

        setCurrentRoom(outside);
    }

    public void play() {
        printWelcome();
        Command command = new Command("", "");
        do {
            command = getParser().getCommand();
        }while(!processCommand(command));
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + getCurrentRoom().getDescription());
        System.out.print("Exits: ");       
        if (getCurrentRoom().getExit(RoomDirections.NORTH) != null) {
            System.out.print("north ");
        }
        if (getCurrentRoom().getExit(RoomDirections.EAST) != null) {
            System.out.print("east ");
        }
        if (getCurrentRoom().getExit(RoomDirections.SOUTH) != null) {
            System.out.print("south ");
        }
        if (getCurrentRoom().getExit(RoomDirections.WEST) != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    private void goRoom(Command command) {
        if (!command.hasDirectionWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getDirectionWord();

        Room nextRoom = null;
        nextRoom = determineNextRoom(direction);

        if (nextRoom != null) {
            setCurrentRoom(nextRoom);
            System.out.println("You are " + getCurrentRoom().getDescription());
            System.out.print("Exits: ");
            if (getCurrentRoom().getExit(RoomDirections.NORTH) != null) {
                System.out.print("north ");
            }
            if (getCurrentRoom().getExit(RoomDirections.EAST) != null) {
                System.out.print("east ");
            }
            if (getCurrentRoom().getExit(RoomDirections.SOUTH) != null) {
                System.out.print("south ");
            }
            if (getCurrentRoom().getExit(RoomDirections.WEST) != null) {
                System.out.print("west ");
            }
            System.out.println();
            
        } else {
            System.out.println("There is no door!");
        }
    }
    
    private Room determineNextRoom(String direction){
        Room nextRoom = null;
        if (direction.equals("north")) {
            nextRoom = getCurrentRoom().getExit(RoomDirections.NORTH);
        }
        if (direction.equals("east")) {
            nextRoom = getCurrentRoom().getExit(RoomDirections.EAST);
        }
        if (direction.equals("south")) {
            nextRoom = getCurrentRoom().getExit(RoomDirections.SOUTH);
        }
        if (direction.equals("west")) {
            nextRoom = getCurrentRoom().getExit(RoomDirections.WEST);
        }
        return nextRoom;
    }

    private boolean quit(Command command) {
        if (command.hasDirectionWord()) {
            System.out.println("Quit what?");
            return false;
        }
        return true;        
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.play();
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
