package com.example.fashionstoreclientside.Model;

import java.io.Serializable;

public class Order implements Serializable{
    private int orderId;
    private String dateOfOrder;
    private int price;
    private String paymentStatus;
    private Customer customer;
    public Order(){}

    public Order(int orderId,String dateOfOrder,int price,String paymentStatus){
        this.orderId=orderId;
        this.dateOfOrder=dateOfOrder;
        this.price=price;
        this.paymentStatus=paymentStatus;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public int getOrderId(){
        return orderId;
    }



}

