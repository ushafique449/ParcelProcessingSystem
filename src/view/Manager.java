package view;

import controller.*;
import java.io.IOException;
import model.*;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Manager {
    public static void main(String[] args) {
         
         // Initialize models
    QueueOfCustomers customerQueue = new QueueOfCustomers();
    ParcelMap parcelMap = new ParcelMap();
    Worker worker = new Worker();

    // Load data from files
    try {
        parcelMap.loadFromFile("C:\\Users\\PC\\Documents\\NetBeansProjects\\ParcelProcessingSystem\\src\\data\\parcels.txt");
        customerQueue.loadFromFile("C:\\Users\\PC\\Documents\\NetBeansProjects\\ParcelProcessingSystem\\src\\data\\customers.txt");
    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }

    // Initialize GUI
    SwingUtilities.invokeLater(() -> {
        MainFrame mainFrame = new MainFrame();
        new MainController(mainFrame, customerQueue, parcelMap, worker);
        mainFrame.setVisible(true);
    });
        
          // Initialize models
       /*
          QueueOfCustomers customerQueue = new QueueOfCustomers();
        ParcelMap parcelMap = new ParcelMap();
        Worker worker = new Worker();

        // Add sample data for testing
        parcelMap.addParcel(new Parcel("P1", new Dimension(10, 5, 8), 2.5, 3));
        parcelMap.addParcel(new Parcel("P2", new Dimension(15, 10, 5), 4.0, 1));
        customerQueue.addCustomer(new Customer(1, "John Doe", "P1"));
        customerQueue.addCustomer(new Customer(2, "Jane Smith", "P2"));

        // Initialize GUI
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            new MainController(mainFrame, customerQueue, parcelMap, worker);
            mainFrame.setVisible(true);
        });
*/
    }
}
