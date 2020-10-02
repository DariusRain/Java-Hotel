package com.coderain;

public class Room {
    private int number;
    private int floor;
    private int averagePrice;
    private String type;
    private Client occupant;
    private boolean isOccupied;
    private boolean needsCleaning;

    public Room(int number, int floor, int averagePrice, String type, Client occupant, boolean isOccupied, boolean needsCleaning) {
        this.number = number;
        this.floor = floor;
        this.averagePrice = averagePrice;
        this.type = type;
        this.occupant = occupant;
        this.isOccupied = isOccupied;
        this.needsCleaning = needsCleaning;
    }

    public boolean reserve(Client occupant) {
        if (needsCleaning == false && isOccupied == false) {
            this.occupant = occupant;
            isOccupied = true;
            return true;
        }
        return false;
    }

    public void checkout() {
        occupant = null;
        isOccupied = false;
        needsCleaning = true;
    }

    public void clean() {
        needsCleaning = false;
    }

    public Client getOccupant() {
        return occupant;
    }

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