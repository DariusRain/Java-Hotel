package com.coderain;

public class StandardRoom extends Room {
    private int rooms;
    private int beds;

//    private int number;
//    private int floor;
//    private int averagePrice;
//    private String type;
//    private Client occupant;
//    private boolean isOccupied = false;
//    private boolean needsCleaning = false;
    public StandardRoom(int number, int floor, int averagePrice, String roomType, Client occupant, boolean isOccupied, boolean needsCleaning, int rooms, int beds) {
        super(number, floor, averagePrice, roomType, occupant, isOccupied, needsCleaning);
        roomType = "Single";
        this.rooms = rooms;
        this.beds = beds;
    }

//    @Override
    public boolean reserve() {
        if (getOccupant().getPartySize() > beds * 2) {
            System.out.println("Unavailable");
        } else {
            super.reserve(getOccupant());
        }
        return false;
    }
}


//    Extends Room
//    type = single
//    rooms ex 1
//    beds ex 1
//    @Override reserve(): If party size > beds * 2 print unavailable otherwise run standard reserve
