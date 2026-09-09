package com.parking_lot_lld.practice.state;

import com.parking_lot_lld.practice.model.spot.ISpot;

public interface IState {

    void assign(ISpot spot);

    void release(ISpot spot);
}
