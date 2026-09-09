package com.parking_lot_lld.notes.pricing;

import com.parking_lot_lld.notes.model.ticket.Ticket;

public class HourlyBikePricingStrategy implements IPricingStrategy {

    private static final double RATE_PER_HOUR = 15.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long durationMillis = ticket.getExitTime() - ticket.getEntryTime();
        double hours = Math.max(1, Math.ceil(durationMillis / (1000.0 * 60 * 60)));
        return hours * RATE_PER_HOUR;
    }
}
