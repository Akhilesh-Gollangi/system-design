package com.parking_lot_lld.interfaces;

import com.parking_lot_lld.SpotSize;

public interface ISpot {

   SpotSize getSize();

   void setState(IState state);

   boolean isAvailable();

   void assignSpot();

   void releaseSpot();
}
