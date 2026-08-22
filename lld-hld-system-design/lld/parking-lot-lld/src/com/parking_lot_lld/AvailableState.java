package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.ISpot;
import com.parking_lot_lld.interfaces.IState;

public class AvailableState implements IState {

    private static AvailableState singleton = new AvailableState();

    private AvailableState() {

    }

    public static AvailableState getInstance() {
        return singleton;
    }

    @Override
    public void assign(ISpot spot) {
        spot.setState(OccupiedState.getInstance());
    }

    @Override
    public void release(ISpot spot) {
        System.out.println("Cannot release as there no vehicle in this spot");
    }
}
