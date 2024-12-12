package com.example.ticket_booking_system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class TicketPool {
    private final List<Ticket> ticketList;
    private final int maxCapacity;
    private final Logger logger = LoggerManager.getLogger();

    public TicketPool(int maxCapacity) {
        this.ticketList = Collections.synchronizedList(new ArrayList<>());
        this.maxCapacity = maxCapacity;
    }

    public void addTicket(int vendorId, int totalTickets, Ticket ticket, int releaseInterval, String eventName,int price) {
        synchronized (ticketList) {
            for (int i = 0; i < totalTickets; i++) {
                while (ticketList.size() >= maxCapacity) {
                    logger.warning("Ticket pool is full. Vendor " + vendorId + " is waiting.");
                    try {
                        ticketList.wait();// Wait on the synchronized object
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore the interrupt status
                        throw new RuntimeException(e);
                    }
                }
                ticket = new Ticket(ticketList.size(), eventName + vendorId, BigDecimal.valueOf(price));
                ticketList.add(ticket);
                logger.info("Vendor " + vendorId + " added a ticket to the pool.");
                try {
                    Thread.sleep(releaseInterval * 1000); // Simulate ticket release delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore the interrupt status
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public Ticket removeTicket(int customerId) {
        synchronized (ticketList) {
            while (ticketList.isEmpty()) {
                try {
                    ticketList.wait();// If ArrayList is empty add Customer to waiting status
                    logger.warning("TicketPool is Empty");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

            Ticket ticket = ticketList.remove(0);
            ticketList.notifyAll();
            logger.info("Customer " + customerId + " retrieved a ticket from the pool. - current size is - " + ticketList.size() + " - Ticket is - " + ticket);
            return ticket;
        }
    }
}