package hotel.rooms;

import hotel.Client;

public abstract class Room {

    private int number;
    private int floor;
    private int averagePrice;
    private int rooms;
    private int beds;
    private RoomTypes type;
    private Client occupant;
    private boolean isOccupied;
    private boolean needsCleaning;

    abstract boolean reserve(Client occupant);

    abstract void checkout();

    abstract void clean();

    abstract Client getOccupant();

    abstract void setRoomType(RoomTypes type);
}

