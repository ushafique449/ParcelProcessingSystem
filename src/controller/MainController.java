package controller;

import java.awt.Font;
import javax.swing.*;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainController {
    private final MainFrame mainFrame;
    private final QueueOfCustomers customerQueue;
    private final ParcelMap parcelMap;
    private final Worker worker;

    public MainController(MainFrame mainFrame, QueueOfCustomers customerQueue, ParcelMap parcelMap, Worker worker) {
        this.mainFrame = mainFrame;
        this.customerQueue = customerQueue;
        this.parcelMap = parcelMap;
        this.worker = worker;

        setupListeners();

        updateCustomerQueuePanel();
        updateParcelListPanel();
        updateProcessingPanel(null, null);
        updateLogPanel();
    }

    private void setupListeners() {
        mainFrame.getProcessButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processNextCustomer();
            }
        });

        
        mainFrame.getAddCustomerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        
        mainFrame.getAddParcelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addParcel();
            }
        });

        
        mainFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApplication();
            }
        });
    }

    
    private void processNextCustomer() {
        Customer customer = customerQueue.removeCustomer();
        if (customer != null) {
            Parcel parcel = parcelMap.getParcel(customer.getParcelId());
            if (parcel != null) {
                worker.processCustomer(customer, parcelMap);
                Log.getInstance().logEvent("Processed customer: " + customer.getName());
                updateCustomerQueuePanel();
                updateParcelListPanel();
                updateProcessingPanel(customer, parcel);
                updateLogPanel();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Parcel not found for customer: " + customer.getName());
            }
        } else {
            JOptionPane.showMessageDialog(mainFrame, "No customers in the queue.");
        }
    }

    
    private void addCustomer() {
        String name = JOptionPane.showInputDialog(mainFrame, "Enter customer name:");
        String parcelId = JOptionPane.showInputDialog(mainFrame, "Enter parcel ID:");
        if (name != null && parcelId != null) {
            int sequenceNumber = customerQueue.getCustomers().size() + 1;
            customerQueue.addCustomer(new Customer(sequenceNumber, name, parcelId));
            Log.getInstance().logEvent("Added customer: " + name);
            updateCustomerQueuePanel();
            updateLogPanel();
        }
    }

    
    private void addParcel() {
        String id = JOptionPane.showInputDialog(mainFrame, "Enter parcel ID:");
        try {
            double weight = Double.parseDouble(JOptionPane.showInputDialog(mainFrame, "Enter parcel weight:"));
            int daysInDepot = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter days in depot:"));
            Dimension dimensions = new Dimension(10, 10, 10); // Example dimensions
            parcelMap.addParcel(new Parcel(id, dimensions, weight, daysInDepot));
            Log.getInstance().logEvent("Added parcel: " + id);
            updateParcelListPanel();
            updateLogPanel();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid input. Parcel not added.");
        }
    }

    
    private void exitApplication() {
        Log.getInstance().saveToFile("log.txt");
        JOptionPane.showMessageDialog(mainFrame, "Logs saved to log.txt. Exiting...");
        System.exit(0);
    }

    
    private void updateCustomerQueuePanel() {
        JPanel customerQueuePanel = mainFrame.getCustomerQueuePanel();
        customerQueuePanel.removeAll();
        for (Customer customer : customerQueue.getCustomers()) {
            JLabel customerLabel = new JLabel(customer.toString());
            customerLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            customerQueuePanel.add(customerLabel);
        }
        customerQueuePanel.revalidate();
        customerQueuePanel.repaint();
    }

    
    private void updateParcelListPanel() {
        JPanel parcelListPanel = mainFrame.getParcelListPanel();
        parcelListPanel.removeAll();
        for (Parcel parcel : parcelMap.getParcels().values()) {
            JLabel parcelLabel = new JLabel(parcel.toString());
            parcelLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            parcelListPanel.add(parcelLabel);
        }
        parcelListPanel.revalidate();
        parcelListPanel.repaint();
    }

    
    private void updateProcessingPanel(Customer customer, Parcel parcel) {
        JPanel processingPanel = mainFrame.getProcessingPanel();
        processingPanel.removeAll();
        if (customer != null && parcel != null) {
            JLabel customerLabel = new JLabel("Customer: " + customer.getName());
            JLabel parcelLabel = new JLabel("Parcel: " + parcel.toString());
            customerLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            parcelLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            processingPanel.add(customerLabel);
            processingPanel.add(parcelLabel);
        } else {
            JLabel noDataLabel = new JLabel("No parcel currently being processed.");
            noDataLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            processingPanel.add(noDataLabel);
        }
        processingPanel.revalidate();
        processingPanel.repaint();
    }

    
    private void updateLogPanel() {
        JPanel logPanel = mainFrame.getLogPanel();
        logPanel.removeAll();
        JLabel logLabel = new JLabel("<html>" + Log.getInstance().getLogs().replace("\n", "<br>") + "</html>");
        logLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        logPanel.add(logLabel);
        logPanel.revalidate();
        logPanel.repaint();
    }
}
