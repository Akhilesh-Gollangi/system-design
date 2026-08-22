package com.parking_lot_lld;

// we are design a parking lot based on the statement
public class Main {

    public static void main(String[] args) {
        // Main is client, Instead of put every thing in main, to keep clean code
        // we have Facade class which is parkingFacade which has park and unpark method
        // Client doesnot car about the logic or behind scenes what is happening can direclty call Facade methods

        //facade has method park and unpark which will make call based on the client action

        // we have to calculate fee when vehicle leaving
        // we have IpriceStrategy which will calculatefee based on the Ticket
        // this is implemented by 2wheeler and 4wheeler, for there own specific logic
        // but how we do call them, during unpark I have to calculate fee, so get object based on size
        // we have factory here

        //WE have Ispot which has getSize() sizeof spot, setState, assingn, is availble, release
        // this is implemented by COMPACT,LARGE, HEAVY

        //when assign or release is called, we will call that particular object assing or release
        // suppose If spot is availbe the assing will go to avialbleState and setState to occupied
        // which specified this state is occupied

        //Istate which has assign and relase, these called from spot
        // this is implemted by Available, Occupied
        // based on the current state, system moves to other state, system do this

    }
}
