package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IPricingStrategy;

public class FourWheelerHourlyPricing implements IPricingStrategy {

    private static final int HOURLY_PRICE = 50;

    @Override
    public double calculateFee(Ticket ticket) {
        long difference = ticket.getExitTime() - ticket.getEntryTime();
        double hours = Math.max(1, Math.ceil(difference / (1000.0 * 60 * 60)));
        return HOURLY_PRICE * hours;
    }
}
