package com.parking_lot_lld.notes.model.spot;

import com.parking_lot_lld.notes.state.IState;

public interface ISpot {

    SpotSize getSize();

    void setState(IState state);

    boolean isAvailable();

    void release();

    void assign();


}
