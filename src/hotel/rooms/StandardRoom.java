package hotel.rooms;

import console.HotelConsole;
import hotel.Client;

public class StandardRoom extends Room {

    private static int beds = 1;
    private int rooms = 1;

    public StandardRoom(int number, int floor, int averagePrice) {
        super(number, floor, averagePrice);
    }


    public boolean reserve(Client client) {
        if (client.getPartySize() > beds * 2) {
            HotelConsole.unavailable(client.getRoomType().toString().toLowerCase());
            return false;
        }
            return super.reserve(client);
    }

//    public void restock() {
//        needsRestock = false;
//    }

}
//    Extends Room
//    type = single
//    hotel.rooms ex 1
//    beds ex 1
//    @Override reserve(): If party size > beds * 2 print unavailable otherwise run standard reserve
