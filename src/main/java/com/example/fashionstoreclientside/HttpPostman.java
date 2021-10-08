package com.example.fashionstoreclientside;

import com.example.fashionstoreclientside.Model.Customer;
import com.example.fashionstoreclientside.Model.Order;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class HttpPostman {
    Client client;
   static int fail=0;
    String baseAddress;
    public HttpPostman(){
        client= ClientBuilder.newClient();
        baseAddress="http://localhost:8080/api/customers";
    }
    public List<Customer> getCustomers(){
        List<Customer>customers=client.target(baseAddress)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Customer>>(){});
        return customers;
    }
    public String changeAddress(String customerSSN,String address) {
        try {
            WebTarget target = client.target(baseAddress).path("{customerSSN}");

            String add = target.resolveTemplate("customerSSN", customerSSN)
                    .request(MediaType.TEXT_PLAIN)
                    .put(Entity.text(address), String.class);
            return add;


        } catch (Exception e) {
            return null;
        }
    }
    public String exit(){

        if(client != null)
            client.close();
        return "connection closed!";
    }
    public Customer getCustomer(String customerSSN){
        WebTarget target=client.target(baseAddress).path("{customerSSN}");

        Customer customer= target.resolveTemplate("customerSSN", customerSSN)
                .request(MediaType.APPLICATION_JSON)
                .get(Customer.class);
        return customer;


    }
    public Order addOrder(String customerSSN, Order order){

      WebTarget target=client.target(baseAddress).path("{customerSSN}").path("/orders");
      Order ord=target.resolveTemplate("customerSSN",customerSSN)
              .request(MediaType.APPLICATION_JSON)
              .post(Entity.json(order),Order.class);



return ord;


    }

    }

