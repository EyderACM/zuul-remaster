public class Room {

    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null) {
            setNorthExit(north);
        }
        if (east != null) {
            setEastExit(east);
        }
        if (south != null) {
            setSouthExit(south);
        }
        if (west != null) {
            setWestExit(west);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getNorthExit() {
        return northExit;
    }

    public void setNorthExit(Room northExit) {
        this.northExit = northExit;
    }

    public Room getSouthExit() {
        return southExit;
    }

    public void setSouthExit(Room southExit) {
        this.southExit = southExit;
    }

    public Room getEastExit() {
        return eastExit;
    }

    public void setEastExit(Room eastExit) {
        this.eastExit = eastExit;
    }

    public Room getWestExit() {
        return westExit;
    }

    public void setWestExit(Room westExit) {
        this.westExit = westExit;
    }
    
}
