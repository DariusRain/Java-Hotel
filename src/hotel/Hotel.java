package hotel;

import hotel.utils.Parser;
import hotel.utils.console.HotelConsole;
import hotel.rooms.Room;
import hotel.rooms.Types;
import hotel.rooms.Standard;
import hotel.rooms.Suite;
import java.util.ArrayList;
//import java.util.HashMap;

public class Hotel {

    private int standardRoomAvgPrice = 84;
    private int suiteRoomAvgPrice = 195;

    private String name;
    private int rooms;
    private ArrayList<Standard> availableStandards = new ArrayList<>();
    private ArrayList<Standard> reservedStandards = new ArrayList<>();
    private ArrayList<Suite> availableSuites = new ArrayList<>();
    private ArrayList<Suite> reservedSuites = new ArrayList<>();
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

    public void addRoom(Types type) {

        int roomNumber = (rooms - (availableStandards.size() + availableSuites.size()));
        int floor = (int)Math.floor(roomNumber * .1);

        if (roomNumber < 0) {
            HotelConsole.alert("Reached desired max room capacity: " + rooms + " rooms are now added!");
            return;
        }

        switch (type) {

            case SINGLE:
                availableStandards.add(new Standard(roomNumber, floor, standardRoomAvgPrice));
                break;

            case SUITE:
                boolean kitchenette = roomNumber % 2 == 0 ? true : false;
                availableSuites.add(new Suite(roomNumber, floor, suiteRoomAvgPrice, kitchenette));
                break;

            default:
                HotelConsole.invalid("" + type);
                break;
        }

    }

//    public

    public int findRoom(Types type, int roomNumber) {
        int indexCount = 0;
        for (Room room : type == Types.SINGLE ? reservedStandards : reservedSuites) {

            if (room.getNumber() == roomNumber) {
                return indexCount;
            }

            indexCount += 1;
        }

        return indexCount;

    }



    public Standard reserveStandardRoom(Client occupant) {
        for (Standard room: availableStandards) {
            if(room.reserve(occupant)) {
                reservedStandards.add(room);
                availableStandards.remove(room);
                return room;
            }
        }
        return new Standard(-1, -1, -1);
    }

    public Suite reserveSuiteRoom(Client occupant, boolean overrider) {
        for (Suite room: availableSuites) {
            if(room.reserve(occupant)) {
                reservedSuites.add(room);
                availableSuites.remove(room);
                return room;
            }
        }
        return new Suite(-1, -1, -1, false);
    }

// Thought I could do an approach like this (ALMOST HAD IT)
//    public <Any> Any reserveRoom(Client occupant) {
//        for (var room: (Parser.genericToList(Parser.getListChoice(occupant.getRoomType(), availableStandards, availableSuites))) ) {
//            if (room.reserve(occupant)) {
//                Parser.genericToList(Parser.getListChoice(occupant.getRoomType(), reservedStandards, reservedSuites))
//                        .add(room);
//            }
//        }
//        return null;
//    }

//    public <Any, Collection> Any reserveRoom(Client occupant) {
//
//        Types type = occupant.getRoomType();
//        String typeToString = type.toString().toLowerCase();
//        HotelConsole.attempt("reserve " + typeToString + " room...");
//
//        Collection listOfRoomsAvailable = Parser.getListChoice(type, availableStandards, availableSuites);
//        Collection listOfRoomsReserved = Parser.getListChoice(type, reservedStandards, reservedSuites);
//
//        if
//            (listOfRoomsAvailable == null || listOfRoomsReserved == null || Parser.genericToList(listOfRoomsAvailable).size() > 0)
//        {
//                return null;
//        }
//
//        ArrayList<? extends Room> parsed = Parser.genericToList(listOfRoomsAvailable);
//
//        int count = 0;
//
//        while(count++<parsed.size()) {
//            if(parsed.get(count).reserve(occupant)) {
//                Parser.genericToList(listOfRoomsAvailable).get(count).reserve(occupant);
//                Parser.genericToList(listOfRoomsReserved).add(Parser.genericToList(listOfRoomsAvailable).get(count));
//
//            }
//
//        }
//            return null;
//    }

    public <G> void checkoutRoom(G room) {

        boolean success = false;

        if (room instanceof Standard) {
            ((Standard)(room)).checkout();
            reservedStandards.remove(room);
            availableStandards.add((Standard) room);
            success = true;
        }

        if (room instanceof Suite) {
            ((Suite)(room)).checkout();
            reservedSuites.remove(room);
            availableSuites.add((Suite) room);
            success = true;
        }

        if (!success) {
            HotelConsole.error("Cannot checkout room...");
        }
        else {
            HotelConsole.success("Checkout completed!");
        }

    }

    public int getClientBalance(int roomNumber) {

        for (Client client: clients) {
            if (client.getRoomNumber() == roomNumber) {
//                hotel.utils.console.log( "Client Balance-> (" + client.getName() + " / #" + roomNumber + "): " + client.getOutstanding());
                return client.getOutstanding();
            }
        }

        return -1;

    }

    public int getClientBalance(String name) {

        for (Client client: clients) {
            if (client.getName().toLowerCase().equals(name.toLowerCase())) {
//                hotel.utils.console.log( "Client Balance-> (" + client.getName() + " / #" + roomNumber + "): " + client.getOutstanding());
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
            HotelConsole.log(counter + "");
                addRoom( counter < nOfStandards ? Types.SINGLE : Types.SUITE);
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