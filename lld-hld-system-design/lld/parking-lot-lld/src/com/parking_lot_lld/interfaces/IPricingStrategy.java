package com.parking_lot_lld.interfaces;

import com.parking_lot_lld.Ticket;

public interface IPricingStrategy {

    double calculateFee(Ticket ticket);
}
