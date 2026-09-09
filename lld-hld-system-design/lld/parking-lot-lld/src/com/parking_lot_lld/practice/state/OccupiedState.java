package com.parking_lot_lld.practice.state;

import com.parking_lot_lld.practice.model.spot.ISpot;

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
