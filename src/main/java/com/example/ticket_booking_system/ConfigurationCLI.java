package com.example.ticket_booking_system;


public class ConfigurationCLI {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.askParameters();
        int eachVendor = config.getTotalTickets()/ config.getVendorCount();
        int ticketPrice = config.getPrice();
        String eventName = config.getEventName();

        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());
        for (int i = 1; i <= config.getVendorCount()/*vendors*/; i++) {
            Vendor vendor = new Vendor(i, (int) config.getTicketReleaseRate(), (int)config.getTicketReleaseRate(), ticketPool, eachVendor,eventName,ticketPrice);
            Thread vendorThread = new Thread(vendor);
            vendorThread.start();
        }

        for (int i = 1; i <= config.getCustomerCount()/*customers*/; i++) {
            Customer customer = new Customer(i, (int)config.getCustomerRetrievalRate(),5, ticketPool);
            Thread customerThread = new Thread(customer);
            customerThread.start();



        }



    }

}
