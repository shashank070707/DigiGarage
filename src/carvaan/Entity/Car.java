/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carvaan.Entity;
import java.sql.Date;

public class Car {
    String registrationNumber;
    String owner;
    String model;
    Date dateOfPurchase;

    public Car(String registrationNumber, String owner, String model, Date dateOfPurchase) {
        this.registrationNumber = registrationNumber;
        this.owner = owner;
        this.model = model;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Car{" + "registrationNumber=" + registrationNumber + ", owner=" + owner + ", model=" + model + ", dateOfPurchase=" + dateOfPurchase + '}';
    }
    
    
    
}
