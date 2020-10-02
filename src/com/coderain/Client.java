package com.coderain;

public class Client {
    private String name;
    private String phoneNumber;
    private String firstname;
    private String lastname;
    private String roomType;
    private int partySize;
    private int prepaid;
    private int currentBill;
    private int roomNumber;
    public int getPartySize() {return partySize;};

    public void makePayment (int payment) {
        prepaid += payment;
    }

    public void chargeRoom (int fee) {
        currentBill += fee;
    }

    public int getOutstanding() {
        return currentBill - prepaid;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    };

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