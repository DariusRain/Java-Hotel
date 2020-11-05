package com.coderain;
import hotel.*;
import hotel.rooms.RoomTypes;

public class Main {

    public static void main(String[] args) {

	    // write your code here
        Hotel marriot = new Hotel("Marriot", 300);
        marriot.initialize(70);
        Client darius = new Client("Darius", "Rain", "4120985674", RoomTypes.SINGLE, 1);
        marriot.reserveRoom(darius);
//        marriot.getRoom();
    }

}
