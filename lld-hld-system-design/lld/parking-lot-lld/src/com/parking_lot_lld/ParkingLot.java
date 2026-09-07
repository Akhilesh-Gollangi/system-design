package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IArea;
import com.parking_lot_lld.interfaces.ISpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements IArea {

    // we can use IArea right in composite pattern, why we Floor here, because in FileManagerment
    // where IFileManagement is interface which a folder can have folder or file
    // in ParkingLot we can have only floor we cannot have ParkingLot inside another.
    private List<Floor> floors;

    private static ParkingLot singleton;

    private ParkingLot() {
        this.floors = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (singleton == null) {
            singleton = new ParkingLot();
        }
        return singleton;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public List<Floor> getAllFloors() {
        return floors;
    }


    //this is composite pattern where parking calls floors availableSpots
    @Override
    public int availableSpots() {
        int total = 0;
        for (Floor floor : floors) {
            for (ISpot spot : floor.getAllSpots()) {
                if (spot.isAvailable()) {
                    total++;
                }
            }
        }
        return total;
    }
}
