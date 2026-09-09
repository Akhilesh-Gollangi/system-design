package com.parking_lot_lld.notes.model.spot;

import com.parking_lot_lld.notes.state.AvailableState;
import com.parking_lot_lld.notes.state.IState;

public class LargeSpot extends CommonSpot {


    @Override
    public SpotSize getSize() {
        return SpotSize.LARGE;
    }

}
