package com.parking_lot_lld.practice.services;

import com.parking_lot_lld.practice.model.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

// why we need TicketManager, we have to save tickets some where right
// here we do this
public class TicketManager {

    private List<Ticket> tickets;

    public TicketManager() {
        this.tickets = new ArrayList<>();
    }

    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }
}
