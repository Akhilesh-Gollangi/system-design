package com.parking_lot_lld.practice.facade;

import com.parking_lot_lld.practice.pricing.PriceStrategyFactory;
import com.parking_lot_lld.practice.services.SpotFinder;
import com.parking_lot_lld.practice.model.ticket.Ticket;
import com.parking_lot_lld.practice.services.TicketManager;
import com.parking_lot_lld.practice.pricing.IPricingStrategy;
import com.parking_lot_lld.practice.model.spot.ISpot;
import com.parking_lot_lld.practice.model.vehicle.IVehicle;

public class ParkingFacade {

    private final SpotFinder spotFinder;

    private final TicketManager ticketManager;

    private final PriceStrategyFactory priceStrategyFactory;


    public ParkingFacade() {
        this.spotFinder = new SpotFinder();
        this.ticketManager = new TicketManager();
        this.priceStrategyFactory = new PriceStrategyFactory();
    }

    public Ticket park(IVehicle vehicle) {
        ISpot spot = spotFinder.findAvailableSpot(vehicle);
        spot.assignSpot();
        Ticket ticket = new Ticket(vehicle, spot, System.currentTimeMillis());
        ticketManager.save(ticket);
        return ticket;
    }

    public double unPark(Ticket ticket) {
        ticket.getSpot().releaseSpot();
        ticket.setExitTime(System.currentTimeMillis());
        IPricingStrategy pricingStrategy = priceStrategyFactory.getPricingStrategy(ticket.getVehicle().getSize());
        return pricingStrategy.calculateFee(ticket);
    }

}
