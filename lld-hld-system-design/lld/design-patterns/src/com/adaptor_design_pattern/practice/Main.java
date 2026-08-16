package com.adaptor_design_pattern.practice;

// Adaptor Design Pattern
//Adapter Design Pattern is a structural pattern that acts as a bridge between two incompatible interfaces,
// allowing them to work together. It is especially useful for integrating legacy code.

// usecase :
// If IPayment Interface with pay method which is implelemeted by card and UPIPayment classes
// From paymentprocessor class by setter injection i calling these method exactly as strtregy pattern

// Now I already have CashPayemt class with method make payment with complicated logic in it
// Our aim is to make cashPayment i also fit in the new structure, without making any changes in cashpayment class

// you can say I will change makepayment method to pay and implements interface in cashPayment,
// As this is existing class, it is used in multiple location, changing this will break many location.
// so we didnot touch existing code

// to solve the we Adapter pattern which is like wrapper on the existing code.
public class Main {

    public static void main(String[] args) {
        IPayment payment = new UPIPayment();
        PaymentProcessor processor = new PaymentProcessor();
        processor.setPayment(payment);
        processor.process();

        payment = new CardPayment();
        processor.setPayment(payment);
        processor.process();

        // we have cashpayment but it is not Ipayment type, but we have to fit  in this
        //without making anychange in cashPayment class
        // so we will create a Adaptor class which will implement Ipayment and at method it will call
        //classpayment makepayment method

        CashPayment cashPayment = new CashPayment();
        IPayment cashPayement = new CashPaymentAdapter(cashPayment);
        processor.setPayment(cashPayement);
        processor.process();


    }
}
