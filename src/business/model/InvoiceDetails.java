/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class InvoiceDetails {
    private String invoiceId;
    private String ticketId;
    private String customerId;
    private float ticketPrice;

    public InvoiceDetails() {
    }

    public InvoiceDetails(String invoiceId, String ticketId, String customerId, float ticketPrice) {
        this.invoiceId = invoiceId;
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.ticketPrice = ticketPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    
}
