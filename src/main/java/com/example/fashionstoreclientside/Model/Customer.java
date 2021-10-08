package com.example.fashionstoreclientside.Model;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    private String SSN;
    private String name;
    private String address;
    private String gender;
    private List<Order> orders;
    public Customer(){}
    public Customer(String SSN,String name,String address,String gender){
        this.SSN=SSN;
        this.name=name;
        this.address=address;
        this.gender=gender;
    }
    public String getSSN(){
        return SSN;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
    public void setSSN(String SSN){
        this.SSN=SSN;
    }
    public void setOrder(List<Order> orders){
        this.orders=orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

}

