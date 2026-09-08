package com.parking_lot_lld.pricing;

import com.parking_lot_lld.model.spot.SpotSize;

import java.util.HashMap;
import java.util.Map;

public class PriceStrategyFactory {

    private static final Map<SpotSize, IPricingStrategy> pricingStrategyMap = new HashMap<>();

    static {
        pricingStrategyMap.put(SpotSize.COMPACT, new TwoWheelHourlyPricing());
        pricingStrategyMap.put(SpotSize.LARGE, new FourWheelerHourlyPricing());
        pricingStrategyMap.put(SpotSize.HEAVY, new HeavyWheelerHourlyPricing());
    }

    public IPricingStrategy getPricingStrategy(SpotSize spotSize) {
        return pricingStrategyMap.get(spotSize);
    }
}
