package com.parking_lot_lld.notes.pricing;

import com.parking_lot_lld.notes.model.ticket.Ticket;

public interface IPricingStrategy {

    double calculateFee(Ticket ticket);
}
