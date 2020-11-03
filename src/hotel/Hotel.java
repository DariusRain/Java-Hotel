package hotel;

import hotel.rooms.StandardRoom;
import hotel.rooms.SuiteRoom;

public class Hotel {

    private String name;
    private int rooms;
    private StandardRoom availableStandards;
    private StandardRoom reservedStandards;
    private SuiteRoom availableSuites;
    private SuiteRoom reservedSuites;
    private Client clients;


    public void addRoom(String roomType) {
            switch (roomType) {
                
            }
    }


    public void reserveRoom() {

    }


    public void checkoutRoom () {

    }



}
/*
name ex: Hotel Java
hotel.rooms: 20
availableStandards: …StandardRooms
reservedStandards: …StandardRooms
availableSuites: …SuiteRooms
reservedSuites: …SuiteRooms
clients: …Clients
addRoom(): Add either a standard or suite to appropriate collection
reserveRoom(): Pull a room from the correct list. if empty print ‘unavailable’ otherwise, run the checkout for the room and move the room from available to reserved. Using the correct collection will make this easier. Add client to clients list
checkoutRoom(): Run the checkout process for a room and move the room from reserved to available.
getClientBalance(): Get the balance of a client by either their room number or name.
Bonus
*/