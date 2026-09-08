package com.parking_lot_lld.pricing;

import com.parking_lot_lld.model.ticket.Ticket;

public class HeavyWheelerHourlyPricing implements IPricingStrategy {

    private static final int HOURLY_PRICE = 65;

    @Override
    public double calculateFee(Ticket ticket) {
        long difference = ticket.getExitTime() - ticket.getEntryTime();
        double hours = Math.max(1, Math.ceil(difference / (1000.0 * 60 * 60)));
        return HOURLY_PRICE*hours;
    }
}
