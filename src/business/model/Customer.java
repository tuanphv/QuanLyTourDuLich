/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class Customer extends User {

    private String registrationDate;
    private String identityNumber;
    private String customerType;

    public Customer() {
    }

    public Customer(String registrationDate, String identityNumber, String customerType, String username, String password, String role, String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address) {
        super(username, password, role, id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.registrationDate = registrationDate;
        this.identityNumber = identityNumber;
        this.customerType = customerType;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    public Object[] toArray() {
        Object[] arr = {this.id, this.username, this.role, this.firstName + " " + this.lastName, this.phoneNumber, this.email, this.customerType, this.registrationDate};
        return arr;
    }
}
