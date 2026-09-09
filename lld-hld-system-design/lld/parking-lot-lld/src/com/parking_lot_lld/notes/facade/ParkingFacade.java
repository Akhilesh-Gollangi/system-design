package com.parking_lot_lld.notes.facade;


import com.parking_lot_lld.notes.model.ticket.Ticket;
import com.parking_lot_lld.notes.model.ticket.TicketManager;
import com.parking_lot_lld.notes.model.vehicle.IVehicle;
import com.parking_lot_lld.notes.model.spot.ISpot;
import com.parking_lot_lld.notes.pricing.IPricingStrategy;
import com.parking_lot_lld.notes.pricing.PricingStrategyFactory;
import com.parking_lot_lld.notes.service.SpotFinder;

public class ParkingFacade {

    private final SpotFinder spotFinder;
    private final PricingStrategyFactory pricingStrategyFactory;
    private final TicketManager ticketManager;

    public ParkingFacade(){
        this.ticketManager = new TicketManager();
        this.pricingStrategyFactory = new PricingStrategyFactory();
        this.spotFinder = new SpotFinder();
    }

    public Ticket parkVehicle(IVehicle vehicle){
        ISpot spot = spotFinder.findAvailableSpot(vehicle);
        spot.assign();

        Ticket ticket = new Ticket(vehicle, spot, System.currentTimeMillis());
        ticketManager.save(ticket);

        return ticket;
    }

    public double unPark(Ticket ticket){

        ticket.setExitTime(System.currentTimeMillis());
        IPricingStrategy strategy =pricingStrategyFactory.getPricingStrategy(ticket.getVehicle());
        double fee = strategy.calculateFee(ticket);

        ticket.getSpot().release();
        return fee;
    }
}
