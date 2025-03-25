/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

import business.model.Service;

/**
 *
 * @author pc
 */
public class Transportation extends Service{
    private String transportType;
    private String company;
    private int capacity;

    public Transportation() {
    }

    public Transportation(String transportType, String company, int capacity, String serviceId, String serviceName, String description, float price, Boolean isAvailable) {
        super(serviceId, serviceName, description, price, isAvailable);
        this.transportType = transportType;
        this.company = company;
        this.capacity = capacity;
    }

    public String getTransportType() {
        return transportType;
    }

    public String getCompany() {
        return company;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
