package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IArea;
import com.parking_lot_lld.interfaces.ISpot;

import java.util.ArrayList;
import java.util.List;

public class Floor implements IArea {

    private String name;

    private List<ISpot> spots;

    public Floor(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
    }

    public void addSpot(ISpot spot) {
        spots.add(spot);
    }

    public List<ISpot> getAllSpots() {
        return spots;
    }

    @Override
    public int availableSpots() {
        int count=0;
        for(ISpot spot:spots) {
            if(spot.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "name='" + name + '\'' +
                ", spots=" + spots +
                '}';
    }
}
