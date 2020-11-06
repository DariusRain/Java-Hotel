package com.coderain;
import console.HotelConsole;
import hotel.*;
import hotel.rooms.*;
public class Main {

    public static void main(String[] args) {

	    // write your code here
        Hotel marriot = new Hotel("Marriot", 300);
        marriot.initialize(70);
        Client darius = new Client("Darius", "Rain", "4120985674", RoomTypes.SINGLE, 1);

        // Checking in
        int roomNumber = marriot.reserveRoom(darius);
        HotelConsole.log("My room number: " + roomNumber);

        // Checking out
        int indexOfMyRoom = marriot.findRoom(darius.getRoomType(), darius.getRoomNumber());

        //
        HotelConsole.log(indexOfMyRoom + "");
//        marriot.checkoutRoom(indexOfMyRoom);
    }

}
