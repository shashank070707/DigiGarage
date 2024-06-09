/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Digigarage.Entity;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Installation {
    String ID;
    String accessoryID;
    String carRegistrationNumber;
    Date dateOfInstallation;

    public Installation(String ID, String accessoryID, String carRegistrationNumber, Date dateOfInstallation) {
        this.ID = ID;
        this.accessoryID = accessoryID;
        this.carRegistrationNumber = carRegistrationNumber;
        this.dateOfInstallation = dateOfInstallation;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAccessoryID() {
        return accessoryID;
    }

    public void setAccessoryID(String accessoryID) {
        this.accessoryID = accessoryID;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public Date getDateOfInstallation() {
        return dateOfInstallation;
    }

    public void setDateOfInstallation(Date dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
    }

    @Override
    public String toString() {
        return "Installation{" + "ID=" + ID + ", accessoryID=" + accessoryID + ", carRegistrationNumber=" + carRegistrationNumber + ", dateOfInstallation=" + dateOfInstallation + '}';
    }
    
    
    
}
