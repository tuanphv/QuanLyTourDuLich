/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.model.Customer;
import java.util.ArrayList;
import persistence.dao.CustomerDAO;

/**
 *
 * @author pc
 */
public class CustomerService {

    private CustomerDAO cusDAO = new CustomerDAO();
    private ArrayList<Customer> list;

    public CustomerService() {
        list = cusDAO.getAllCustomers();
    }

    public ArrayList<Customer> getCustomers() {
        return list;
    }

    public void deleteCustomer(Customer c) {
        list.remove(c);
        cusDAO.deleteCustomer(c.getId());
    }

    public void deleteCustomer(int index) {
        cusDAO.deleteCustomer(list.get(index).getId());
        list.remove(index);
    }

    public void addCustomer(Customer c) {
        list.add(c);
    }

    public void updateCustomer(int index, Customer c) {
        list.set(index, c);
        cusDAO.updateCustomer(c);
    }
}
