package com.parking_lot_lld.practice.model.spot;

import com.parking_lot_lld.practice.state.IState;

public interface ISpot {

   SpotSize getSize();

   void setState(IState state);

   boolean isAvailable();

   void assignSpot();

   void releaseSpot();
}
