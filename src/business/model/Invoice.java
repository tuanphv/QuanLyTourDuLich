/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class Invoice {
    private String invoiceId;
    private String customerId;
    private String employeeId;
    private String tourPlanId;
    private int ticketCount;
    private float totalAmount;
    private String notes;
    private String promoCode;
    private String invoiceDate;
    private String status;

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerId, String employeeId, String tourPlanId, int ticketCount, float totalAmount, String notes, String promoCode, String invoiceDate, String status) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.tourPlanId = tourPlanId;
        this.ticketCount = ticketCount;
        this.totalAmount = totalAmount;
        this.notes = notes;
        this.promoCode = promoCode;
        this.invoiceDate = invoiceDate;
        this.status = status;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getTourPlanId() {
        return tourPlanId;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public String getNotes() {
        return notes;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setTourPlanId(String tourPlanId) {
        this.tourPlanId = tourPlanId;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
