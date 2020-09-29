package com.coderain;

public class Room {
    private int number;
    private int floor;
    private int averagePrice;
    private String type;
//    private CLient occupant;
    private boolean isOccupied;
    private boolean needsCleaning;
//    reserve()
//    checkout()
//    clean()
}


/*
Room
    number ex: 102
    type ex: ’single’
    floor ex: 3
    isOccupied: false
    needsCleaning: false
    occupant: a Client
    averagePrice: 38000
    reserve(): = Should change room to isOccupied and assign the client to the occupant if isOccupied and needsCleaning are false otherwise print “unavailable” Should return true if successful or false if issue.
    checkout(): Remove the client from object and mark isOccupied as false, set needsCleaning to true, display o outstanding balance for the client.
    clean(): Set needsCleaning to false
*/