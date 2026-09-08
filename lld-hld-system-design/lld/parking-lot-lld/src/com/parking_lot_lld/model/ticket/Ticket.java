package com.parking_lot_lld.model.ticket;

import com.parking_lot_lld.model.spot.ISpot;
import com.parking_lot_lld.model.vehicle.IVehicle;

public class Ticket {

    private final IVehicle vehicle;

    private final ISpot spot;

    private final long entryTime;

    private long exitTime;

    // As we are assign vehicle,spot and entrytime only once we create the object
    // These are not going to change as well, so we can make varibles final
    public Ticket(IVehicle vehicle, ISpot spot, long entryTime) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
    }

    // we vehicle is leaving we will set exit time, to calulate the fee
    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public IVehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public ISpot getSpot() {
        return spot;
    }
}
