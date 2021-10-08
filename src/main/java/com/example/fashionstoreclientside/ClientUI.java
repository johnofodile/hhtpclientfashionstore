package com.example.fashionstoreclientside;

import com.example.fashionstoreclientside.Model.Customer;
import com.example.fashionstoreclientside.Model.Order;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ClientUI {
    HttpPostman httpPostman = new HttpPostman();
    Scanner scanner;
    int number = 1;
    String updatedAddress = null;

    public ClientUI() {
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int response;
        boolean running = true;


        while (running) {
            try {
                System.out.println("...........Make your choice...........");
                System.out.println("1.View all Customers");
                System.out.println("2.Find a specific customer");
                System.out.println("3.Add customer order");
                System.out.println("4.Change customer address");
                System.out.println(("5.Exit"));
                System.out.println(".........Enter your choice........");
                response = Integer.parseInt(scanner.nextLine());
                if (response == 1) {
                    List<Customer> customer = httpPostman.getCustomers();
                    System.out.println("size:  " + customer.size());
                    try {
                        for (Customer cus : customer) {
                            System.out.println("SSN:   " + cus.getSSN());
                            System.out.println("name:  " + cus.getName());
                            System.out.println("address:   " + cus.getAddress());
                            System.out.println("gender:    " + cus.getGender());
                            for (Order ord : cus.getOrders()) {
                                System.out.println("orderId:  " + ord.getOrderId());
                                System.out.println("dateOfOrder:  " + ord.getDateOfOrder());
                                System.out.println("price:  " + ord.getPrice());
                                System.out.println("paymentStatus:  " + ord.getPaymentStatus());


                            }


                        }
                    } catch (NullPointerException e) {

                    }


                } else if (response == 2) {
                    System.out.println("Type your customer SSN :");
                    String ssn = scanner.nextLine().trim();
                    Customer cus = httpPostman.getCustomer(ssn);
                    System.out.println("The above ssn number belongs to:  " + cus.getName());
                    System.out.println("his address is:  " + cus.getAddress());
                    for (Order o : cus.getOrders()) {
                        System.out.println("orderId:  " + o.getOrderId() + "  dateoforder:  " + o.getDateOfOrder()
                                + "price: " + o.getPrice() + "paymentstatus " + o.getPaymentStatus());


                    }
                } else if (response == 3) {

                    System.out.println("Type the customer SSN");
                    String ssn = scanner.nextLine().trim();
                    System.out.println("Type the date of order");
                    String date = scanner.nextLine().trim();
                    System.out.println("Type the price");
                    int price = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Enter the payment status");
                    String paymentStatus = scanner.nextLine().trim();
                    Order order = new Order();
                    order.setDateOfOrder(date);
                    order.setPrice(price);
                    order.setPaymentStatus(paymentStatus);
                    Order finalOrder = httpPostman.addOrder(ssn, order);
                    System.out.println("order succesfully added");


                } else if (response == 4) {
                    System.out.println("Enter the new address");
                    String address = scanner.nextLine().trim();
                    System.out.println("Enter customer SSN");
                    String ssn = scanner.nextLine();
                    updatedAddress = httpPostman.changeAddress(ssn, address);


                    if (updatedAddress.isEmpty())
                        System.out.println("The SSN you input is incorrect please try again");
                    if (updatedAddress != null)
                        System.out.println("The updated address is:" + updatedAddress);

                } else if (response == 5) {
                    String msg = httpPostman.exit();
                    System.out.println(msg);
                    running = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid response please input a number");
            }

        }
    }
}
