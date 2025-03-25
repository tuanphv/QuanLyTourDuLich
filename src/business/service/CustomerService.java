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
    public ArrayList<Customer> getCustomers() {
        return cusDAO.getAllCustomers();
    }
}
