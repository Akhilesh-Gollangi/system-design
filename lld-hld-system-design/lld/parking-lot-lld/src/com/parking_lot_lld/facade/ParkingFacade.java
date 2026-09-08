package com.parking_lot_lld.facade;

import com.parking_lot_lld.pricing.PriceStrategyFactory;
import com.parking_lot_lld.services.SpotFinder;
import com.parking_lot_lld.model.ticket.Ticket;
import com.parking_lot_lld.services.TicketManager;
import com.parking_lot_lld.pricing.IPricingStrategy;
import com.parking_lot_lld.model.spot.ISpot;
import com.parking_lot_lld.model.vehicle.IVehicle;

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
