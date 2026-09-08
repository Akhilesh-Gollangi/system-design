package com.parking_lot_lld.state;

import com.parking_lot_lld.model.spot.ISpot;

public interface IState {

    void assign(ISpot spot);

    void release(ISpot spot);
}
