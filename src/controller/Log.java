/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author PC
 */
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
}