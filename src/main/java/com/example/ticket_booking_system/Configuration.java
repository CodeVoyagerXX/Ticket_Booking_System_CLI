package com.example.ticket_booking_system;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private int vendorCount;
    private int CustomerCount;
    private String eventName;
    private int price;


    public Configuration() {}
    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int vendorCount, int customerCount, String eventName, int price ){
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = totalTickets;
        this.vendorCount= vendorCount;
        this.CustomerCount = customerCount;
        this.eventName = eventName;
        this.price = price;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public double getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) { this.ticketReleaseRate = ticketReleaseRate;
    }

    public double getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) { this.customerRetrievalRate = customerRetrievalRate;
    }
    public int getMaxTicketCapacity() { return maxTicketCapacity;
    }
    public void setMaxTicketCapacity(int maxTicketCapacity) { this.maxTicketCapacity = maxTicketCapacity;
    }
    public int getVendorCount() { return vendorCount;
    }
    public void setVendorCount(int vendorCount) { this.vendorCount = vendorCount;
    }
    public int getCustomerCount() { return CustomerCount;
    }
    public void setCustomerCount(int customerCount) { CustomerCount = customerCount;
    }
    public String getEventName() { return eventName;
    }

    public void setEventName(String eventName) { this.eventName = eventName;
    }
    public int getPrice() { return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void askParameters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Ticketing System Configuration");

    // Total Tickets
        System.out.print("Enter the total number of tickets: ");
        setTotalTickets(getPositiveInteger(scanner));

    // Ticket Release Rate
        System.out.print("Enter the ticket release rate (e.g., 1 to 50 tickets per second): ");
        setTicketReleaseRate(getValidatedRate(scanner, 1, 50));

    // Customer Retrieval Rate
        System.out.print("Enter the customer retrieval rate (e.g., 1 to 30 tickets per second): ");
        setCustomerRetrievalRate(getValidatedRate(scanner, 1, 30));

    // Maximum Ticket Capacity
        System.out.print("Enter the maximum ticket capacity: ");
        setMaxTicketCapacity(getPositiveInteger(scanner));

    // VendorCount
        System.out.print("Enter number of vendors: ");
        setVendorCount(getPositiveInteger(scanner));

    // CustomerCount
        System.out.print("Enter number of Customers: ");
        setCustomerCount(getPositiveInteger(scanner));

    // Event name
        System.out.print("Enter Event Name: ");
        setEventName(scanner.nextLine());

    //Ticket Price
        System.out.print("Ticket Price: ");
        setPrice(getPositiveInteger(scanner));


        System.out.println("\nConfiguration Complete:");
        System.out.println("Total Tickets: " + getTotalTickets());
        System.out.println("Ticket Release Rate: " + getTicketReleaseRate());
        System.out.println("Customer Retrieval Rate: " + getCustomerRetrievalRate());
        System.out.println("Max Ticket Capacity: " + getMaxTicketCapacity());
        System.out.println("Number of vendors: " + getVendorCount());
        System.out.println("Number of Customers: " + getCustomerCount());

        scanner.close();
}

// Helper method to validate and get positive integers
private static int getPositiveInteger(Scanner scanner) {
    int value;
    while (true) {
        try {
            value = Integer.parseInt(scanner.nextLine());
            if (value > 0) {
                return value;
            } else {
                System.out.print("Please enter a positive number: ");
            }
        } catch (NumberFormatException e) {
            System.out.print("Invalid input. Please enter a number: ");
        }
    }
}

// Helper method to validate rates within a specified range
private static int getValidatedRate(Scanner scanner, int min, int max) {
    int value;
    while (true) {
        try {
            value = Integer.parseInt(scanner.nextLine());
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.printf("Please enter a value between %d and %d: ", min, max);
            }
        } catch (NumberFormatException e) {
            System.out.print("Invalid input. Please enter a number: ");
        }
    }
}
}
