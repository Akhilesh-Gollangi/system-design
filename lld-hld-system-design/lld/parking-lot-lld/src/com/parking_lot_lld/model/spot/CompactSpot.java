package com.parking_lot_lld.model.spot;

public class CompactSpot extends CommonSpot {

    @Override
    public SpotSize getSize() {
        return SpotSize.COMPACT;
    }

}
