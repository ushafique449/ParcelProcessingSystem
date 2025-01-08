package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static Log instance = null;
    private StringBuilder events;


    private Log() {
        events = new StringBuilder();
    }


    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }


    public void logEvent(String event) {
        events.append(event).append("\n");
    }


    public String getLogs() {
        return events.toString();
    }


   public void saveToFile(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        writer.write(events.toString());
    } catch (IOException e) {
        System.out.println("Error saving log to file: " + e.getMessage());
    }
}

}
