package com.parking_lot_lld.practice.factory;

import com.parking_lot_lld.practice.model.spot.SpotSize;
import com.parking_lot_lld.practice.model.spot.ISpot;
import com.parking_lot_lld.practice.model.spot.CompactSpot;
import com.parking_lot_lld.practice.model.spot.HeavySpot;
import com.parking_lot_lld.practice.model.spot.LargeSpot;

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
