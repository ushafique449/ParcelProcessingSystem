package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static Log instance = null;
    private StringBuilder events;

    // Private constructor for Singleton pattern
    private Log() {
        events = new StringBuilder();
    }

    // Singleton instance getter
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    // Method to log events
    public void logEvent(String event) {
        events.append(event).append("\n");
    }

    // Method to get all logged events as a string
    public String getLogs() {
        return events.toString();
    }

    // Method to save logged events to a file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(events.toString());
        } catch (IOException e) {
            System.out.println("Error saving log to file: " + e.getMessage());
        }
    }
}
