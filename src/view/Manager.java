package view;

import controller.*;
import model.*;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Manager {
    public static void main(String[] args) {
         
        
        
          // Initialize models
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
        
        
        
        
        
        
        
        
        
        
        /*
        ParcelMap parcelMap = new ParcelMap();
        QueueOfCustomers queue = new QueueOfCustomers();
        Worker worker = new Worker();

        // Hardcoded sample data
        parcelMap.addParcel(new Parcel("P1", new Dimension(10, 5, 8), 2.5, 3));
        parcelMap.addParcel(new Parcel("P2", new Dimension(15, 10, 5), 4.0, 1));
        queue.addCustomer(new Customer(1, "James Bond", "P1"));
        queue.addCustomer(new Customer(2, "Jian Smith2"
                + "", "P2"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Parcel Processing System ---");
            System.out.println("1. Process Next Customer");
            System.out.println("2. View Remaining Parcels");
            System.out.println("3. View Customer Queue");
            System.out.println("4. View Logs");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Declare customer outside the switch to avoid redefining
                    Customer customer = queue.removeCustomer();
                    if (customer != null) {
                        worker.processCustomer(customer, parcelMap);
                    } else {
                        System.out.println("No customers in the queue.");
                    }
                    break;
                case 2:
                    System.out.println("Remaining Parcels:");
                    for (Parcel parcel : parcelMap.getParcels().values()) {
                        System.out.println(parcel);
                    }
                    break;
                case 3:
                    System.out.println("Customer Queue:");
                    for (Customer c : queue.getCustomers()) { // Use a distinct name for the loop variable
                        System.out.println(c);
                    }
                    break;
                case 4:
                    System.out.println("Logs:");
                    System.out.println(Log.getInstance().getLogs());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }*/
    }
}
