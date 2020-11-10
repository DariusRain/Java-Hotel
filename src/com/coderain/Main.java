package com.coderain;
import hotel.utils.console.HotelConsole;
import hotel.*;
import hotel.rooms.*;
public class Main {

    public static void main(String[] args) {

	    // write your code here
        Hotel marriot = new Hotel("Marriot", 300);
        marriot.initialize(70);
        Client person1 = new Client("Darius", "Rain", "4120985674", Types.SINGLE, 1);
        Client person2 = new Client("Darius", "Rain", "4120985674", Types.SUITE, 1);

        // Checking in
        Standard reservedRoom1 = marriot.reserveStandardRoom(person1);
        Suite reservedRoom2 = marriot.reserveSuiteRoom(person2);

        HotelConsole.log("Persoon 1 room number: " + reservedRoom1.getNumber());
        HotelConsole.log("Persoon 2 room number: " + reservedRoom2.getNumber());

        // Checking out
          marriot.checkoutRoom(reservedRoom1);
          marriot.checkoutRoom(reservedRoom2);

    }

}

