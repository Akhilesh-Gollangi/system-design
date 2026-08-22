package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.ISpot;
import com.parking_lot_lld.interfaces.IState;

public class LargeSpot implements ISpot {

    // default state is available
    private IState state = AvailableState.getInstance();

    @Override
    public SpotSize getSize() {
        return SpotSize.LARGE;
    }

    @Override
    public void setState(IState state) {
        this.state = state;
    }

    @Override
    public boolean isAvailable() {
        return state == AvailableState.getInstance();
    }

    @Override
    public void assignSpot() {
        state.assign(this);
    }

    @Override
    public void releaseSpot() {
        state.release(this);
    }
}
