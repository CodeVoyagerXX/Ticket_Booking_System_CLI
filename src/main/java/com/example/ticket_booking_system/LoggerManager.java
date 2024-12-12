package com.example.ticket_booking_system;

import java.io.IOException;
import java.util.logging.*;

public class LoggerManager {
    private static final Logger logger = Logger.getLogger(LoggerManager.class.getName());

    static {
        try {
            // Set up FileHandler for logging to a file
            FileHandler fileHandler = new FileHandler("ticketsystem.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Set up ConsoleHandler for logging to the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            logger.addHandler(consoleHandler);

            // Set log level
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            System.err.println("Failed to set up logging: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}

