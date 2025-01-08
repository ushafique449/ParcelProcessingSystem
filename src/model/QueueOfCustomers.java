package model;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;

public class QueueOfCustomers {
    private Queue<Customer> customers;

    public QueueOfCustomers() {
        customers = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer removeCustomer() {
        return customers.poll();
    }

    public Queue<Customer> getCustomers() {
        return customers;
    }
    
    public void loadFromFile(String filename) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        boolean firstLine = true; 
        int sequenceNumber = 1;

        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }

            
            String[] data = line.split(",");

            
            String name = data[0];
            String parcelId = data[1];

            
            addCustomer(new Customer(sequenceNumber++, name, parcelId));
        }
    }
}
}