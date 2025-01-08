package view;

import controller.*;
import java.io.IOException;
import model.*;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Manager {
    public static void main(String[] args) {
         

    QueueOfCustomers customerQueue = new QueueOfCustomers();
    ParcelMap parcelMap = new ParcelMap();
    Worker worker = new Worker();


    try {
        parcelMap.loadFromFile("resources/Parcels.csv");
        customerQueue.loadFromFile("resources/Custs.csv");
    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }


    SwingUtilities.invokeLater(() -> {
        MainFrame mainFrame = new MainFrame();
        new MainController(mainFrame, customerQueue, parcelMap, worker);
        mainFrame.setVisible(true);
    });
        
    }
}
