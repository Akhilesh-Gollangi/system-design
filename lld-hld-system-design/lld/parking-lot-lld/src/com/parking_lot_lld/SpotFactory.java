package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.ISpot;

import java.util.HashMap;
import java.util.Map;

public class SpotFactory {
    private static final Map<SpotSize, ISpot> spotStrategyMap = new HashMap<>();

    static {
        spotStrategyMap.put(SpotSize.COMPACT, new CompactSpot());
        spotStrategyMap.put(SpotSize.LARGE, new LargeSpot());
        spotStrategyMap.put(SpotSize.HEAVY, new HeavySpot());
    }

    public ISpot createSpot(SpotSize spotSize) {
        return spotStrategyMap.get(spotSize);
    }
}
