package com.parking_lot_lld.pricing;

import com.parking_lot_lld.model.ticket.Ticket;

public interface IPricingStrategy {

    double calculateFee(Ticket ticket);
}
