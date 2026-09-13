package com.parking_lot_lld.practice.model.spot;

import com.parking_lot_lld.practice.state.AvailableState;
import com.parking_lot_lld.practice.state.IState;

public abstract class CommonSpot implements ISpot{

    // default state is available
    protected IState state = AvailableState.getInstance();

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
