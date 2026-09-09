package com.parking_lot_lld.notes.state;

import com.parking_lot_lld.notes.model.spot.ISpot;

public interface IState {

    void assign(ISpot spot);

    void release(ISpot spot);
}
