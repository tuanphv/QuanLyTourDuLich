/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author pc
 */
public class Employee extends User {

    private String startDate;
    private String position;
    private String status;

    public Employee() {
    }

    public Employee(String startDate, String position, String status, String username, String password, String role, String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address) {
        super(username, password, role, id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.startDate = startDate;
        this.position = position;
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getPosition() {
        return position;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
