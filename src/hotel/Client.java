package hotel;

import hotel.utils.console.HotelConsole;
import hotel.rooms.Types;

public class Client {

    private String name;
    private String phoneNumber;
    private String firstname;
    private String lastname;
    private Types roomType;
    private int partySize;
    private int roomNumber = -1;
    private int prepaid = 0;
    private int currentBill = 0;

    public Client(String firstname, String lastname, String phoneNumber, Types roomType, int partySize) {
        name = firstname + " " + lastname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roomType = roomType;
        this.partySize = partySize;
        this.phoneNumber = phoneNumber;
    }


    public int getPartySize() {return partySize;}

    public void makePayment (int payment) {
        prepaid += payment;
    }

    public void chargeRoom (int fee) {
        currentBill += fee;
    }

    public int getOutstanding() {
        return currentBill - prepaid;
    }

    public void setRoomNumber(int roomNumber) {
        HotelConsole.log((this.roomNumber == -1 ? roomNumber : this.roomNumber) + "");
        //        this.roomNumber = this.roomNumber == -1 ? roomNumber : this.roomNumber;
    }

    public void setRoomType(Types roomType) {
        this.roomType = roomType;
    };

    public Types getRoomType() {return roomType;}

    public int getRoomNumber() {return roomNumber;}

    public String getName() {return name;}


}

// Client
//         name ex: John Doe
//         partySize: 1
//         currentBill ex: 450
//         prepaid ex: 100
//         phoneNumber: 555-555-5555
//         roomNumber: 302
//         roomType: ‘double’
//         makePayment(): Increase prepaid
//         chargeRoom(): Increase current bill
//         getOustanding(): Get outstanding balance.