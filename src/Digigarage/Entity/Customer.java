/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Digigarage.Entity;

/**
 *
 * @author HP
 */
public class Customer {
    String phoneNumber;
    String name;
    String address;

    public Customer(String phoneNumber, String name, String address) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "phoneNumber=" + phoneNumber + ", name=" + name + ", address=" + address + '}';
    }
    
    
    
}
