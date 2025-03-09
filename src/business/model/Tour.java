/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class Tour {
    private String tourId;
    private String tourName;
    private String price;
    private String status;
    private String details;
    private String thumbnail;
    private String departurePoint; //điểm khởi hành =))
    private String destination;
    private String tourType;
    private String numDay;
    private String numNight;

    public Tour() {
    }

    public Tour(String tourId, String tourName, String price, String status, String details, String thumbnail, String departurePoint, String destination, String tourType, String numDay, String numNight) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.status = status;
        this.details = details;
        this.thumbnail = thumbnail;
        this.departurePoint = departurePoint;
        this.destination = destination;
        this.tourType = tourType;
        this.numDay = numDay;
        this.numNight = numNight;
    }

    public String getTourId() {
        return tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public String getDestination() {
        return destination;
    }

    public String getTourType() {
        return tourType;
    }

    public String getNumDay() {
        return numDay;
    }

    public String getNumNight() {
        return numNight;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    public void setNumDay(String numDay) {
        this.numDay = numDay;
    }

    public void setNumNight(String numNight) {
        this.numNight = numNight;
    }
    
}
