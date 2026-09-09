package com.parking_lot_lld.notes.App;

import com.parking_lot_lld.notes.exception.NoAvailableSpotException;
import com.parking_lot_lld.notes.facade.ParkingFacade;
import com.parking_lot_lld.notes.factory.SpotFactory;
import com.parking_lot_lld.notes.model.parking.Floor;
import com.parking_lot_lld.notes.model.parking.ParkingLot;
import com.parking_lot_lld.notes.model.spot.CompactSpot;
import com.parking_lot_lld.notes.model.spot.SpotSize;
import com.parking_lot_lld.notes.model.ticket.Ticket;
import com.parking_lot_lld.notes.model.vehicle.FourWheeler;
import com.parking_lot_lld.notes.model.vehicle.HeavyFourWheeler;
import com.parking_lot_lld.notes.model.vehicle.IVehicle;
import com.parking_lot_lld.notes.model.vehicle.TwoWheeler;

public class Main {

    public static void main(String[] args) {
        SpotFactory spotFactory = new SpotFactory();

        Floor groundFloor = new Floor("Ground model.parking.Floor");
        groundFloor.addSpot(spotFactory.getSpot(SpotSize.COMPACT));
        groundFloor.addSpot(spotFactory.getSpot(SpotSize.COMPACT));
        groundFloor.addSpot(spotFactory.getSpot(SpotSize.LARGE));
        groundFloor.addSpot(spotFactory.getSpot(SpotSize.HEAVY));

        ParkingLot.getInstance().addFloor(groundFloor);

        System.out.println("Available spots at start: " + ParkingLot.getInstance().availableSpots());

        ParkingFacade facade = new ParkingFacade();

        IVehicle car = new FourWheeler();
        Ticket carTicket = facade.parkVehicle(car);
        System.out.println("Parked car. Available spots now: " + ParkingLot.getInstance().availableSpots());

        double carFee = facade.unPark(carTicket);
        System.out.println("Car fee charged (HourlyCarPricing): " + carFee);
        System.out.println("Available spots after car exits: " + ParkingLot.getInstance().availableSpots());

        IVehicle bike = new TwoWheeler();
        Ticket bikeTicket = facade.parkVehicle(bike);
        System.out.println("Parked bike. Available spots now: " + ParkingLot.getInstance().availableSpots());

        double bikeFee = facade.unPark(bikeTicket);
        System.out.println("Available spots after bike exits: " + ParkingLot.getInstance().availableSpots());

        System.out.println("Bike fee charged (HourlyBikePricing): " + bikeFee);

        IVehicle heavyTruck1 = new HeavyFourWheeler();
        IVehicle heavyTruck2 = new HeavyFourWheeler();
        facade.parkVehicle(heavyTruck1);

        try {
            facade.parkVehicle(heavyTruck2);
        } catch (NoAvailableSpotException e) {
            System.out.println("Expected failure: " + e.getMessage());
        }
    }
}
