// Unused example of interface
package hotel.rooms;

import hotel.Client;

public interface RoomServices {
//    int number;
//    int floor;
//    int averagePrice;
//    int rooms;
//    int beds;
//    RoomTypes type = RoomTypes.STANDARD;
//    Client occupant;
//    boolean isOccupied;
//    boolean needsCleaning;

    public boolean reserve();

    public void checkout();

    public void clean();

    public Client getOccupant();

    public void setRoomType(Types type);
}

