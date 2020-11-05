package hotel;

import console.HotelConsole;
import hotel.rooms.Room;
import hotel.rooms.RoomTypes;
import hotel.rooms.StandardRoom;
import hotel.rooms.SuiteRoom;
import java.util.ArrayList;
//import java.util.HashMap;

public class Hotel {

    private int standardRoomAvgPrice = 84;
    private int suiteRoomAvgPrice = 195;

    private String name;
    private int rooms;
    private ArrayList<StandardRoom> availableStandards = new ArrayList<>();
    private ArrayList<StandardRoom> reservedStandards = new ArrayList<>();
    private ArrayList<SuiteRoom> availableSuites = new ArrayList<>();
    private ArrayList<SuiteRoom> reservedSuites = new ArrayList<>();
    private ArrayList<Client> clients =  new ArrayList<>();

    public Hotel(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public Hotel(String name, int rooms, int standardRoomAvgPrice, int suiteRoomAvgPrice) {
        this.name = name;
        this.rooms = rooms;
        this.standardRoomAvgPrice = standardRoomAvgPrice;
        this.suiteRoomAvgPrice = suiteRoomAvgPrice;
    }

    public void addRoom(RoomTypes type) {

        int roomNumber = (rooms - (availableStandards.size() + availableSuites.size()));
        int floor = (int)Math.floor(roomNumber * .1);

        if (roomNumber < 0) {
            HotelConsole.alert("Reached desired max room capacity: " + rooms + " rooms are now added!");
            return;
        }

        switch (type) {

            case SINGLE:
                availableStandards.add(new StandardRoom(roomNumber, floor, standardRoomAvgPrice));
                break;

            case SUITE:
                availableSuites.add(new SuiteRoom(roomNumber, floor, suiteRoomAvgPrice, roomNumber % 2 == 0 ? true : false));
                break;

            default:
                HotelConsole.invalid("" + type);
                break;
        }

    }



    public int reserveRoom(Client client) {

        int roomNumber = -1;
        RoomTypes type = client.getRoomType();
        String typeToString = type.toString().toLowerCase();
        HotelConsole.attempt("reserve " + typeToString + " room");

        switch (type) {

            case SINGLE:
                if (availableStandards.size() > 0 && availableStandards.get(0).reserve(client)) {
                        client.setRoomNumber(availableStandards.get(0).getNumber());
                        clients.add(client);
                        reservedStandards.add(availableStandards.get(0));
                        availableStandards.remove(availableStandards.get(0));
                }
                break;

            case SUITE:
                if (availableSuites.size() > 0 && availableSuites.get(0).reserve(client)) {
                    reservedSuites.add(availableSuites.get(0));
                    availableStandards.remove(availableStandards.get(0));
                    clients.add(client);
                }
                break;

            default:
                HotelConsole.invalid( "" + type);
                break;
        }

        if (roomNumber < 0 ) {
            HotelConsole.unavailable("No " + typeToString + " rooms available...");
        }

        return roomNumber;

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