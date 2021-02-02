
import java.util.HashMap;

public class Room {

    private String description;
    private RoomExits roomExits = new RoomExits();

    public Room(String description) {
        this.description = description;
    }

    public void setRoomExits(HashMap<RoomDirections, Room> roomExits) {
        this.roomExits.setRooms(roomExits);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getExit(RoomDirections direction) {
        return roomExits.getRooms().get(direction);
    }
    
}
