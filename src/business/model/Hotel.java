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
public class Hotel extends Service{
    private String hotelName;
    private int starRating;
    private String location;
    private Boolean hasBreakfast;

    public Hotel() {
    }

    public Hotel(String hotelName, int starRating, String location, Boolean hasBreakfast, String serviceId, String serviceName, String description, float price, Boolean isAvailable) {
        super(serviceId, serviceName, description, price, isAvailable);
        this.hotelName = hotelName;
        this.starRating = starRating;
        this.location = location;
        this.hasBreakfast = hasBreakfast;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getStarRating() {
        return starRating;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getHasBreakfast() {
        return hasBreakfast;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHasBreakfast(Boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }
    
    
}
