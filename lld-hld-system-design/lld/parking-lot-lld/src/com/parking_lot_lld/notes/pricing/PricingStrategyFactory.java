package com.parking_lot_lld.notes.pricing;

import com.parking_lot_lld.notes.model.spot.SpotSize;
import com.parking_lot_lld.notes.model.vehicle.IVehicle;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyFactory {

    private static final Map<SpotSize, IPricingStrategy> strategies = new HashMap<>();


    //mapping
    static {
        strategies.put(SpotSize.COMPACT,new HourlyBikePricingStrategy());
        strategies.put(SpotSize.LARGE,new HourlyCarPricingStrategy());
        strategies.put(SpotSize.HEAVY,new HourlyCarPricingStrategy());
    }

    // what the unpark method would be using
    public IPricingStrategy getPricingStrategy(IVehicle vehicle) {
        return strategies.get(vehicle.getSize());
    }

}
