package com.adaptor_design_pattern.practice;

// this is existing class

// we have to make  this class compatiable to Ipayments
// without making any change in this class
public class CashPayment {

    public void makePayment() {
        System.out.println("Payment made using Cash.");
    }
}