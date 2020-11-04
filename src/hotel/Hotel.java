package hotel;

import console.Console;
import hotel.rooms.Room;
import hotel.rooms.StandardRoom;
import hotel.rooms.SuiteRoom;
import hotel.rooms.RoomTypes;
import java.util.ArrayList;
//import java.util.HashMap;

public class Hotel {

    private int standardRoomAvgPrice = 84;
    private int suiteRoomAvgPrice = 195;

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


    public void addRoom(RoomTypes type) {

        int roomNumber = (rooms - (availableStandards.size() + availableSuites.size()));
        int floor = (int)Math.floor(roomNumber * .1);

        if (roomNumber < 0) {
            console.log("Cannot add more rooms");
            return;
        }

        switch (type) {

            case SINGLE:
                console.log("Adding standard room...");
                availableStandards.add(new StandardRoom(roomNumber, floor, standardRoomAvgPrice));
                break;

            case SUITE:
                console.log("Adding a suite room...");
                availableSuites.add(new SuiteRoom(roomNumber, floor, suiteRoomAvgPrice));
                break;

            default:
                console.log("Invalid room type " + type);
                break;
        }

    }


    public void reserveRoom(Client client) {
        switch (client.getRoomType()) {

            case SINGLE:
                console.log("Reserving standard..");

                if (availableStandards.size() > 0) {

                    availableStandards.get(0).reserve(client);
                    reservedStandards.add(availableStandards.get(0));
                    availableStandards.remove(availableStandards.get(0));
                    clients.add(client);

                } else {

                    console.log("No standard rooms available...");

                }
                break;

            case SUITE:
                console.log("Reserving suite...");
                if (availableSuites.size() > 0) {

                    availableSuites.get(0).reserve(client);
                    reservedSuites.add(availableSuites.get(0));
                    availableStandards.remove(availableStandards.get(0));
                    clients.add(client);

                } else {

                    console.log("No suite rooms available...");

                }
                break;

            default:
                console.log("Invalid room type " + client.getRoomType());
                break;
        }

    }



    public < Generic extends Room > void checkoutRoom(Generic room) {

        room.checkout();

        if (room.getType() == RoomTypes.SINGLE) {
            availableStandards.add( (StandardRoom) room);
        }

        if (room.getType() == RoomTypes.SUITE) {
            availableSuites.add( (SuiteRoom) room);
        }

    }

    public int getClientBalance(int roomNumber) {

        for (Client client: clients) {
            if (client.getRoomNumber() == roomNumber) {
//                console.log( "Client Balance-> (" + client.getName() + " / #" + roomNumber + "): " + client.getOutstanding());
                return client.getOutstanding();
            }
        }

        return -1;

    }

    public int getClientBalance(String name) {

        for (Client client: clients) {
            if (client.getName().toLowerCase().equals(name.toLowerCase())) {
//                console.log( "Client Balance-> (" + client.getName() + " / #" + roomNumber + "): " + client.getOutstanding());
                return client.getOutstanding();
            }
        }

        return -1;

    }


    public void initialize(int percentage) {
        int nOfStandards = (int)(rooms * (percentage * .01));
        int nOfSuites = rooms - nOfStandards;
        int counter = 0;
        while(counter++ < nOfStandards + nOfSuites) {
                addRoom( counter < nOfStandards ? RoomTypes.SINGLE : RoomTypes.SUITE);
        }
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