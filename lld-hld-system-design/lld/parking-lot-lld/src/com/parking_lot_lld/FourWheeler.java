package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IVehicle;

public class FourWheeler implements IVehicle {
    @Override
    public SpotSize getSize() {
        return SpotSize.LARGE;
    }
}
