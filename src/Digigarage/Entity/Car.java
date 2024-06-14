/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Digigarage.Entity;
import java.sql.Date;

public class Car {
    String registrationNumber;
    String ownerName;
    String ownerContact;
    String model;
    Date dateOfPurchase;

    public Car(String registrationNumber, String ownerName, String ownerContact, String model, Date dateOfPurchase) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
        this.model = model;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public String getModel() {
        return model;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Car{" + "registrationNumber=" + registrationNumber + ", ownerName=" + ownerName + ", ownerContact=" + ownerContact + ", model=" + model + ", dateOfPurchase=" + dateOfPurchase + '}';
    }

    
    
}
