package hotel.rooms;

import console.HotelConsole;
import hotel.Client;

public class Room {

    private int number;
    private int floor;
    private int averagePrice;
    private RoomTypes type = RoomTypes.SINGLE;
    private Client occupant;
    public boolean isOccupied = false;
    public boolean needsCleaning = false;

    public Room(int number, int floor, int averagePrice) {

        this.number = number;
        this.floor = floor;
        this.averagePrice = averagePrice;

    }

    public boolean reserve(Client occupant) {

        if (needsCleaning == false && isOccupied == false) {

            occupant.setRoomNumber(number);
            this.occupant = occupant;
            isOccupied = true;
            return true;

        }

        HotelConsole.unavailable("" + occupant.getRoomType());

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

    protected void setType(RoomTypes type) {
        this.type = type;
    }

//    public boolean isAvailable() {
//        return isOccupied && !needsCleaning;
//    }

    public RoomTypes getType() {
        return type;
    }

    public int getNumber() {return  number;}

}


//Room class
//    number ex: 102
//    type ex: ’single’
//    floor ex: 3
//    isOccupied: false
//    needsCleaning: false
//    occupant: a Client
//    averagePrice: 38000
//    reserve = Should change room to isOccupied and assign the client to the occupant if isOccupied and needsCleaning are false otherwise print “unavailable” Should return true if successful or false if issue.
//    checkout = remove the client from object and mark isOccupied as false, set needsCleaning to true, display o outstanding balance for the client.
//    clean = set needsCleaning to false
