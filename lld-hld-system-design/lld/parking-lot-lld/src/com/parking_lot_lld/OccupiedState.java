package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.ISpot;
import com.parking_lot_lld.interfaces.IState;

public class OccupiedState implements IState {

    private static OccupiedState singleton = new OccupiedState();

    private OccupiedState() {

    }

    public static OccupiedState getInstance() {
        return singleton;
    }

    @Override
    public void assign(ISpot spot) {
        System.out.println("Already vehicle is present, spot is not avilable");
    }

    @Override
    public void release(ISpot spot) {
        spot.setState(AvailableState.getInstance());
    }
}
