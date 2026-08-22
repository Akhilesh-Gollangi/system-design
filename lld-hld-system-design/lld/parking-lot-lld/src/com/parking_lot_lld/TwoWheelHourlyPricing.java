package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IPricingStrategy;

public class TwoWheelHourlyPricing implements IPricingStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        return 25.0;
    }
}
