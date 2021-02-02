
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class RoomExits {
    private HashMap<RoomDirections, Room> rooms;

    public RoomExits() {
        rooms = new HashMap<>();
    }
    
    public HashMap<RoomDirections, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<RoomDirections, Room> rooms) {
        this.rooms = rooms;
    }
    
}
