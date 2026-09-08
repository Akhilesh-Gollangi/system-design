package com.parking_lot_lld.services;

import com.parking_lot_lld.model.parkinglot.Floor;
import com.parking_lot_lld.exception.NoAvailableSpotException;
import com.parking_lot_lld.model.parkinglot.ParkingLot;
import com.parking_lot_lld.model.spot.ISpot;
import com.parking_lot_lld.model.vehicle.IVehicle;

public class SpotFinder {
    private static final ParkingLot PARKING_LOT = ParkingLot.getInstance();

    public ISpot findAvailableSpot(IVehicle vehicle) {
        if (PARKING_LOT.availableSpots() == 0) {
            throw new NoAvailableSpotException("No Spots Available");
        }
        for (Floor floor : PARKING_LOT.getAllFloors()) {
            for (ISpot spot : floor.getAllSpots()) {
                if (spot.isAvailable() && vehicle.getSize() == spot.getSize()) {
                    return spot;
                }
            }
        }
        throw new NoAvailableSpotException("No Spots Available");
    }
}
