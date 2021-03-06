package hotel.rooms;

import hotel.Client;

public class Suite extends Room  {


    private boolean kitchenette;
    private boolean needsRestock = false;
    private static int beds = 4;
    private static int rooms = 3;


    public Suite(int number, int floor, int averagePrice, boolean kitchenette) {
        super(number, floor, averagePrice);
        this.kitchenette = kitchenette;
        setType(Types.SUITE);
    }


    public boolean reserve(Client occupant) {
        if (!needsRestock) {
            return super.reserve(occupant);
        }
        return false;
    }


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