/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class HotelService extends Service{
    private String hotelName;
    private int starRating;
    private String location;
    private Boolean hasBreakfast;

    public HotelService() {
    }

    public HotelService(String hotelName, int starRating, String location, Boolean hasBreakfast, String serviceId, String serviceName, String description, float price, Boolean isAvailable) {
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
