package com.parking_lot_lld.model.spot;

import com.parking_lot_lld.state.IState;

public interface ISpot {

   SpotSize getSize();

   void setState(IState state);

   boolean isAvailable();

   void assignSpot();

   void releaseSpot();
}
