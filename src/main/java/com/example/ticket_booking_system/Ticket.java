package com.example.ticket_booking_system;

import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String event;
    private BigDecimal price;


    public Ticket(int ticketId, String event, BigDecimal price) {
        this.ticketId = ticketId;
        this.event = event;
        this.price = price;
    }
    public int getTicketId(){
        return ticketId;
    }
    public void setTicketId(){
        this.ticketId = ticketId;
    }
    public String getEvent(){
        return event;
    }
    public void setevent(){
        this.event = event;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(){
        this.price = price;
    }
    @Override
    public String toString(){
        return "Ticket [ticketId=" + ticketId + ", event=" + event + ", price=" + price + "]";
    }
}
