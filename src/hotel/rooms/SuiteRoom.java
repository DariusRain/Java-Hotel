package hotel.rooms;

import hotel.Client;

public class SuiteRoom extends Room {

    private boolean kitchenette;
    private boolean needsRestock = false;

    public SuiteRoom(int number, int floor, int averagePrice, RoomTypes type, Client occupant, boolean isOccupied, boolean needsCleaning, int rooms, int beds) {
        super(number, floor, averagePrice, type, occupant, isOccupied, needsCleaning);
        setRoomType(RoomTypes.SUITE);
        this.kitchenette = kitchenette;
    }


    public boolean reserve() {
        if (needsRestock) {
            super.reserve(getOccupant());
        }
        return false;
    }

    public void restock() {
        needsRestock = false;
    }

}

/*
type = suite
hotel.rooms ex 2
beds example 1
kitchenette ex: true
needsRestock: false
@Override reserve(): include a check on needsRestock then run standard reserve.
@Override checkout(): set needsRestock to true run standard checkout.
restock(): set needs restock to false
*/