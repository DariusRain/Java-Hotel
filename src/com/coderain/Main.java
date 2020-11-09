package com.coderain;
import hotel.utils.console.HotelConsole;
import hotel.*;
import hotel.rooms.*;
public class Main {

    public static void main(String[] args) {

	    // write your code here
        Hotel marriot = new Hotel("Marriot", 300);
        marriot.initialize(70);
        Client darius = new Client("Darius", "Rain", "4120985674", Types.SINGLE, 1);

        // Checking in
        Standard reservedRoom = marriot.reserveStandardRoom(darius);
        HotelConsole.log("My room number: " + reservedRoom.getNumber());

        // Checking out
        //  int indexOfMyRoom = marriot.findRoom(darius.getRoomType(), darius.getRoomNumber());
          reservedRoom.checkout();
          marriot.checkoutRoom(reservedRoom);
        //
        HotelConsole.log();
//        marriot.checkoutRoom(indexOfMyRoom);
    }

}
