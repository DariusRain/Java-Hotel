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
                boolean kitchenette = roomNumber % 2 == 0 ? true : false;
                availableSuites.add(new SuiteRoom(roomNumber, floor, suiteRoomAvgPrice, kitchenette));
                break;

            default:
                HotelConsole.invalid("" + type);
                break;
        }

    }

//    public

    public int findRoom(RoomTypes type, int roomNumber) {
        int indexCount = 0;
        for (Room room: type == RoomTypes.SINGLE ? reservedStandards : reservedSuites) {

            if (room.getNumber() == roomNumber) {
                return indexCount;
            }

            indexCount += 1;
        }

        return indexCount;

    }
// https://stackoverflow.com/questions/450807/how-do-i-make-the-method-return-type-generic
//    public <G> G reserveRoom(Client client) {
//
//        RoomTypes type = client.getRoomType();
//        String typeToString = type.toString().toLowerCase();
//        HotelConsole.attempt("reserve " + typeToString + " room...");
//        G anyRoom = (G)null;
//        switch (type) {
//
//            case SINGLE:
//            case SUITE:
//                System.out.println(availableStandards.size() + " " + availableStandards.get(0).getNumber());
//                System.out.println(availableStandards.size() > 0 && availableStandards.get(0).reserve(client));
//                if (availableStandards.size() > 0 && availableStandards.get(0).reserve(client)) {
//                        StandardRoom selected = availableStandards.get(0);
//                        anyRoom = (G)(selected);
//                        client.setRoomNumber(selected.getNumber());
//                        clients.add(client);
//                        reservedStandards.add(availableStandards.get(0));
//                        availableStandards.remove(availableStandards.get(0));
//                }
//                break;
//
//                System.out.println(availableSuites.size() + " " + availableSuites.get(0).getNumber());
//                System.out.println(availableSuites.size() > 0 && availableSuites.get(0).reserve(client));
//                if (availableSuites.size() > 0 && availableSuites.get(0).reserve(client)) {
//                    client.setRoomNumber();
//                    reservedSuites.add(availableSuites.get(0));
//                    availableStandards.remove(availableStandards.get(0));
//                    clients.add(client);
//                }
//                break;
//
//            default:
//                HotelConsole.invalid( "" + type);
//                break;
//        }
//
//
//
//        return anyRoom;
//
//    }
    
//    public <>

    public <AnyRoom, CollectionAvailable, CollectionReserved> AnyRoom reserveRoom(Client occupant) {

        RoomTypes type = occupant.getRoomType();
        String typeToString = type.toString().toLowerCase();
        HotelConsole.attempt("reserve " + typeToString + " room...");
        ArrayList<? extends Room> listOfRoomsAvailable = (ArrayList<? extends Room>) (type == RoomTypes.SINGLE ? availableStandards : type == RoomTypes.SUITE ? availableSuites : null);
        ArrayList<? extends Room> listOfRoomsReserved = (ArrayList<? extends Room>) (type == RoomTypes.SINGLE ? reservedStandards : type == RoomTypes.SUITE ? reservedSuites : null);

        if(listOfRoomsAvailable == null) {
            return (AnyRoom)null;
        }

//        collection = (AnyCollection)(collection instanceof ArrayList ? (ArrayList<?>)collection : null);
        boolean isRoomAvailable = ( ( ArrayList<? extends Room> ) listOfRoomsAvailable ).size() > 0;
        boolean isRoomReservable = ( ( ArrayList<? extends Room> ) listOfRoomsAvailable ).get(0).reserve(occupant);



        if (isRoomAvailable && isRoomReservable) {

            Class<? extends Room> room = (Class<? extends Room>)((( ( ArrayList<? extends Room> ) listOfRoomsAvailable )).get(0);
            clients.add(occupant);
            listOfRoomsReserved.add(room);
            availableStandards.remove(availableStandards.get(0));

        }

            if (availableSuites.size() > 0 && availableSuites.get(0).reserve(client)) {
                client.setRoomNumber();
                reservedSuites.add(availableSuites.get(0));
                availableStandards.remove(availableStandards.get(0));
                clients.add(client);
            }


            return anyRoom;

    }

    public <G> void checkoutRoom(G room) {
        boolean success = false;
        if (room instanceof StandardRoom) {
            ((StandardRoom)(room)).checkout();
            success = true;
        }
        if (room instanceof SuiteRoom) {
            ((SuiteRoom)(room)).checkout();
            success = true;
        }
        if (!success) {
            HotelConsole.error("Cannot checkout room...");
        } else {
            HotelConsole.success("Checkout completed!");
        }

    }
//    public void checkoutRoom(RoomTypes type, int index) {
//        if (type == RoomTypes.SINGLE) {
//            reservedStandards.get(index).checkout();
//        }
//
//        room.checkout();
//        availableStandards.add(room);
//
//    }

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
            HotelConsole.log(counter + "");
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