package com.example.ticket_booking_system;

public class Vendor implements Runnable {
    private int vendorId;
    private int totalTickets;
    private int ticketsPerRelease;
    private int releaseInterval;
    private TicketPool ticketPool;// Reference to TicketPool instance
    private Ticket ticket;
    private int ticketPrice;
    private String eventName;

    public Vendor(int vendorId, int ticketsPerRelease, int releaseInterval, TicketPool ticketPool,int totalTickets,String eventName, int ticketPrice) {
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;// Assign TicketPool instance
        this.totalTickets = totalTickets;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void run() {
            addTicket();
    }

    private void addTicket() {

            ticketPool.addTicket(vendorId, totalTickets, ticket, releaseInterval,eventName,ticketPrice);
            System.out.println("Vendor "+vendorId+" add a ticket batch. ");


    }
}
