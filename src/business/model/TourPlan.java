/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class TourPlan {
    private String tourPlanId;
    private String tourId;
    private String startDate;
    private String endDate;
    private int ticketLimit;
    private int ticketsBooked;
    private String status;
    private float totalCost;
    private float totalRevenue;

    public TourPlan() {
    }

    public TourPlan(String tourPlanId, String tourId, String startDate, String endDate, int ticketLimit, int ticketsBooked, String status, float totalCost, float totalRevenue) {
        this.tourPlanId = tourPlanId;
        this.tourId = tourId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketLimit = ticketLimit;
        this.ticketsBooked = ticketsBooked;
        this.status = status;
        this.totalCost = totalCost;
        this.totalRevenue = totalRevenue;
    }

    public String getTourPlanId() {
        return tourPlanId;
    }

    public String getTourId() {
        return tourId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getTicketLimit() {
        return ticketLimit;
    }

    public int getTicketsBooked() {
        return ticketsBooked;
    }

    public String getStatus() {
        return status;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public void setTourPlanId(String tourPlanId) {
        this.tourPlanId = tourPlanId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTicketLimit(int ticketLimit) {
        this.ticketLimit = ticketLimit;
    }

    public void setTicketsBooked(int ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalRevenue(float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    
    
}
