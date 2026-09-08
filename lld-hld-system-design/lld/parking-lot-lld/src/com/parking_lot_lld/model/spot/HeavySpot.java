package com.parking_lot_lld.model.spot;

public class HeavySpot extends CommonSpot {

    @Override
    public SpotSize getSize() {
        return SpotSize.HEAVY;
    }

}
