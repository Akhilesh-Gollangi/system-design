package com.parking_lot_lld.practice.pricing;

import com.parking_lot_lld.practice.model.ticket.Ticket;

public interface IPricingStrategy {

    double calculateFee(Ticket ticket);
}
