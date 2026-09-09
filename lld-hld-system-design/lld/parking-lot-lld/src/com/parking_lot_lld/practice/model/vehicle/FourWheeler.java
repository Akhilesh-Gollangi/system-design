package com.parking_lot_lld.practice.model.vehicle;

import com.parking_lot_lld.practice.model.spot.SpotSize;

public class FourWheeler implements IVehicle {
    @Override
    public SpotSize getSize() {
        return SpotSize.LARGE;
    }
}
