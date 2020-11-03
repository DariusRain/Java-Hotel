package hotel.rooms;

import hotel.Client;

public class StandardRoom extends Room {

    private int number;
    private int floor;
    private int averagePrice;
    private int rooms;
    private int beds;
    private RoomTypes type = RoomTypes.STANDARD;
    private Client occupant;
    private boolean isOccupied;
    private boolean needsCleaning;

    public Room(int number, int floor, int averagePrice, RoomTypes type, Client occupant, boolean isOccupied, boolean needsCleaning) {
        this.number = number;
        this.floor = floor;
        this.averagePrice = averagePrice;
        this.occupant = occupant;
        this.isOccupied = isOccupied;
        this.needsCleaning = needsCleaning;
    }

    public boolean reserve(Client occupant) {
        if (needsCleaning == false && isOccupied == false) {
            this.occupant = occupant;
            isOccupied = true;
            return true;
        }

        return false;
    }

    public void checkout() {
        occupant = null;
        isOccupied = false;
        needsCleaning = true;
    }

    public void clean() {
        needsCleaning = false;
    }

    public Client getOccupant() {
        return occupant;
    }

    protected void setRoomType(RoomTypes type) {
        this.type = type;
    }
}
//    Extends Room
//    type = single
//    hotel.rooms ex 1
//    beds ex 1
//    @Override reserve(): If party size > beds * 2 print unavailable otherwise run standard reserve
