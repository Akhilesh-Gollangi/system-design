package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IPricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class PriceStrategyFactory {

    private static Map<SpotSize, IPricingStrategy> pricingStrategyMap= new HashMap<>();

    static {
        pricingStrategyMap.put(SpotSize.COMPACT,new TwoWheelHourlyPricing());
        pricingStrategyMap.put(SpotSize.LARGE, new FourWheelerHourlyPricing());
    }

    public static IPricingStrategy getPricingStrategy(SpotSize spotSize) {
        return pricingStrategyMap.get(spotSize);
    }
}
