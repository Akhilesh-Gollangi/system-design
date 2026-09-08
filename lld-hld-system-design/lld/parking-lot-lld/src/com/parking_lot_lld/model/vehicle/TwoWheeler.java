package com.parking_lot_lld.model.vehicle;

import com.parking_lot_lld.model.spot.SpotSize;

public class TwoWheeler implements IVehicle {
    @Override
    public SpotSize getSize() {
        return SpotSize.COMPACT;
    }
}
