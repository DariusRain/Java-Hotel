package com.coderain;

public class SuiteRoom extends Room {
    private int rooms;
    private int beds;
    private boolean kitchenette;
    private boolean needsRestock = false;

    public SuiteRoom(int number, int floor, int averagePrice, String type, Client occupant, boolean isOccupied, boolean needsCleaning, int rooms, int beds, boolean needsRestock, boolean kitchenette) {
        super(number, floor, averagePrice, type, occupant, isOccupied, needsCleaning);
        type = "suite";
        this.rooms = rooms;
        this.beds = beds;
        this.kitchenette = kitchenette;
    }

//    @Override
    public boolean reserve() {
        if (needsRestock) {
            super.reserve(getOccupant());
        }
        return false;
    }

    @Override
    public void checkout() {
        needsRestock = true;
        super.checkout();
    }
    public void restock() {
        needsRestock = false;
    }
}

/*
type = suite
rooms ex 2
beds example 1
kitchenette ex: true
needsRestock: false
@Override reserve(): include a check on needsRestock then run standard reserve.
@Override checkout(): set needsRestock to true run standard checkout.
restock(): set needs restock to false
*/