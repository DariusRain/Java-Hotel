# Hotel 

#### Classes
#### &nbsp; Room
* number ex: 102
* type ex: ’single’
* floor ex: 3
* isOccupied: false
* needsCleaning: false
* occupant: a Client
* averagePrice: 38000
* reserve(): = Should change room to isOccupied and assign the client to the occupant if isOccupied and needsCleaning are false otherwise print “unavailable” Should return true if successful or false if issue.
* checkout(): Remove the client from object and mark isOccupied as false, set needsCleaning to true, display o outstanding balance for the client.
* clean(): Set needsCleaning to false
&nbsp;

#### &nbsp; StandardRoom extends Room
* …Room
* type = single
* rooms ex 1
* beds ex 1
* @Override reserve(): If party size > beds * 2 print unavailable otherwise run standard reserve 
&nbsp;

#### &nbsp; SuiteRoom extends Room
* type = suite
* rooms ex 2
* beds example 1
* kitchenette ex: true
* needsRestock: false
* @Override reserve(): include a check on needsRestock then run standard reserve.
* @Override checkout(): set needsRestock to true run standard checkout.
* restock(): set needs restock to false
&nbsp;

#### &nbsp; Client
* name ex: John Doe
* partySize: 1
* currentBill ex: 450
* prepaid ex: 100
* phoneNumber: 555-555-5555
* roomNumber: 302
* roomType: ‘double’
* makePayment(): Increase prepaid 
* chargeRoom(): Increase current bill
* getOustanding(): Get outstanding balance.
&nbsp;

#### &nbsp; Hotel class:
* name ex: Hotel Java
* rooms: 20
* availableStandards: …StandardRooms
* reservedStandards: …StandardRooms
* availableSuites: …SuiteRooms
* reservedSuites: …SuiteRooms
* clients: …Clients
* addRoom(): Add either a standard or suite to appropriate collection
* reserveRoom(): Pull a room from the correct list. if empty print ‘unavailable’ otherwise, run the checkout for the room and move the room from available to reserved. Using the correct collection will make this easier. Add client to clients list
* checkoutRoom(): Run the checkout process for a room and move the room from reserved to available.
* getClientBalance(): Get the balance of a client by either their room number or name.


#### Bonus
Additional challenge add a calculate price method.  This method should increase the price by x% for each person above bed * 2 with a maximum capacity for the room at bed * 2 + room * 2. Example a 1 bed 1 room can take 4 people max with 2 having a fee applied. a 2 bed 2 room has max occupancy of 8 with 4 being subject to fee. A 1 bed 3 room also has 8 occupancy but 6 fees can be applied. The standard room applies a 5% fee and suites apply an 8% fee. Note this means the standard rooms will no longer deny at 2*bed but now deny at 2*bed + 2 * room. While the suite will not deny but if over capacity increase price by additional 50% per person after capacity.
