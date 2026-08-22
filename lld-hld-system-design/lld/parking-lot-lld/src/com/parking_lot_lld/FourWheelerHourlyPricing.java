package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IPricingStrategy;

public class FourWheelerHourlyPricing implements IPricingStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        return 50.0;
    }
}
