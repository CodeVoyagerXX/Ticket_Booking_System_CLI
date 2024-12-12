package com.example.ticket_booking_system;

public class Customer implements Runnable {
    private int customerId;
    private int customerRetrievalRate;
    private int quantity;
    private TicketPool ticketPool;

    public Customer(int customerId, int customerRetrievalRate, int quantity, TicketPool ticketPool) {
        this.customerId = customerId;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = ticketPool.removeTicket(customerId); // Call method to buyTickets
            System.out.println("Ticket is - " + ticket + " - Customer " + customerId);
            try {
                Thread.sleep(customerRetrievalRate * 1000); // Retieving delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
