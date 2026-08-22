package com.parking_lot_lld.interfaces;

public interface IState {

    void assign(ISpot spot);

    void release(ISpot spot);
}
