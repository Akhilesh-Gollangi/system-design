package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IVehicle;

// we are design a parking lot based on the statement
public class Main {

    // As it is singleton
    private static final ParkingLot PARKING_LOT = ParkingLot.getInstance();


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

        // IVehicle implemented by twowheeler, FOurWheeler, HeavyWheeler
        // return spotSize


        // Ticket with vehicle, spot, entrytime, exittime
        // Entry and exit time to calculate the fee

        // Ticket manager class to save tickets

        // SpotFinder class to find first available spot match to vehicle size

        // Parking Facade to park and unpark
        // park -> check spot, assign spot, then create ticket, save ticket and return ticket
        // unpark -> release spot, set exittime, get pricingStrtegy based on vehiclesize then calculate fee, return fee


        //Now Admin and client which is main class

        //admin duty to create Parkinglot, floors,spots
        // we have to create multiple spots based on Size
        // so we will have spotFactory which will return spot based on size

        SpotFactory spotFactory = new SpotFactory();

        Floor floor = new Floor("Ground Floor");

        floor.addSpot(spotFactory.createSpot(SpotSize.COMPACT));
        floor.addSpot(spotFactory.createSpot(SpotSize.LARGE));
        floor.addSpot(spotFactory.createSpot(SpotSize.HEAVY));

        PARKING_LOT.addFloor(floor);

        System.out.println("Floor Created :"+ floor.toString());

        // Now from client we will get vehicles
        System.out.println("Total Avaialable spots: " + PARKING_LOT.availableSpots());

        ParkingFacade parkingFacade = new ParkingFacade();
        IVehicle bike = new TwoWheeler();
        Ticket bikeTicket = parkingFacade.park(bike);
        System.out.println("Bike Parked, Avaialable spots: " + PARKING_LOT.availableSpots());
        System.out.println(parkingFacade.unPark(bikeTicket));

        System.out.println("Total Avaialable spots: " + PARKING_LOT.availableSpots());

        IVehicle car = new FourWheeler();
        Ticket catTicket = parkingFacade.park(car);
        System.out.println("car Parked, Avaialable spots: " + PARKING_LOT.availableSpots());


        IVehicle truck = new HeavyWheeler();
        Ticket truckTicket = parkingFacade.park(truck);
        System.out.println("Truck Parked, Avaialable spots: " + PARKING_LOT.availableSpots());

        System.out.println(parkingFacade.unPark(catTicket));
        System.out.println("car left, Avaialable spots: " + PARKING_LOT.availableSpots());

        IVehicle truck2 = new HeavyWheeler();
        try {
            Ticket truckTicket2 = parkingFacade.park(truck);
        } catch (Exception e) {
            System.out.println("Expected Exception: "+ e.getMessage());
        }


    }
}
