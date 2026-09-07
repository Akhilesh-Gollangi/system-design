package com.parking_lot_lld;

import com.parking_lot_lld.interfaces.IPricingStrategy;
import com.parking_lot_lld.interfaces.ISpot;
import com.parking_lot_lld.interfaces.IVehicle;

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
