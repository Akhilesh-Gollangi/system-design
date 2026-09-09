package com.parking_lot_lld.notes.service;

import com.parking_lot_lld.notes.exception.NoAvailableSpotException;
import com.parking_lot_lld.notes.model.parking.Floor;
import com.parking_lot_lld.notes.model.parking.ParkingLot;
import com.parking_lot_lld.notes.model.vehicle.IVehicle;
import com.parking_lot_lld.notes.model.spot.ISpot;

public class SpotFinder {

    public ISpot findAvailableSpot(IVehicle vehicle){

        ParkingLot lot = ParkingLot.getInstance();

        for(Floor floor : lot.getFloors()){

            for(ISpot spot : floor.getAllSpots()){
                if(spot.isAvailable() && spot.getSize() == vehicle.getSize()){
                    return spot;
                }
            }
        }

        throw new NoAvailableSpotException("NO spots available");
    }
}
