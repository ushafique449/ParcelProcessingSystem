/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.LinkedList;
import java.util.Queue;
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
}