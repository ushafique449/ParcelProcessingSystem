/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
/**
 *
 * @author PC
 */
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
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            int sequenceNumber = Integer.parseInt(data[0]);
            String name = data[1];
            String parcelId = data[2];
            addCustomer(new Customer(sequenceNumber, name, parcelId));
        }
    }
}
}