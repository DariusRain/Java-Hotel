package hotel;

import console.Console;
import hotel.rooms.Room;
import hotel.rooms.StandardRoom;
import hotel.rooms.SuiteRoom;
import hotel.rooms.RoomTypes;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private static int standardRoomAvgPrice = 84;
    private static int suiteRoomAvgPrice = 195;

    private String name;
    private int rooms;
    private Console console = new Console();
    private ArrayList<StandardRoom> availableStandards = new ArrayList<>();
    private ArrayList<StandardRoom> reservedStandards = new ArrayList<>();
    private ArrayList<SuiteRoom> availableSuites = new ArrayList<>();
    private ArrayList<SuiteRoom> reservedSuites = new ArrayList<>();
    private ArrayList<Client> clients =  new ArrayList<>();

    public Hotel(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
    }


    public void addRoom(RoomTypes roomType) {
        int roomNumber = (rooms - (availableStandards.size() + availableSuites.size()));
        int floor = (int)Math.floor(roomNumber * .1);
        if (roomNumber < 0) {
            console.log("Cannot add more rooms");
            return;
        }
        switch (roomType) {
            case SINGLE:
                console.log("Adding standard room...");
                availableStandards.add(new StandardRoom(roomNumber, floor, standardRoomAvgPrice));
                break;
            case SUITE:
                console.log("Adding a suite room...");
                availableSuites.add(new SuiteRoom(roomNumber, floor, suiteRoomAvgPrice));
                break;

            default:
                console.log("Invalid room type " + roomType);
                break;
            }
    }


    public void reserveRoom() {

    }


    public void checkoutRoom() {

    }

    public void getClientBalance() {

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