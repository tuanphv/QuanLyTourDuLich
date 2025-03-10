/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;


/**
 *
 * @author pc
 */
public class RestaurantService extends Service{
    private String restaurantName;
    private String location;
    private String serviceType;

    public RestaurantService() {
    }

    public RestaurantService(String restaurantName, String location, String serviceType, String serviceId, String serviceName, String description, float price, Boolean isAvailable) {
        super(serviceId, serviceName, description, price, isAvailable);
        this.restaurantName = restaurantName;
        this.location = location;
        this.serviceType = serviceType;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    
    
}
