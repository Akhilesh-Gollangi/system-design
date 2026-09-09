package com.parking_lot_lld.notes.model.vehicle;

import com.parking_lot_lld.notes.model.spot.SpotSize;

public class TwoWheeler implements IVehicle {
    @Override
    public SpotSize getSize() {
        return SpotSize.COMPACT;
    }
}
