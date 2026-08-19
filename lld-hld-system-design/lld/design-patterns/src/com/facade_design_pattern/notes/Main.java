package com.facade_design_pattern.notes;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(499.0);

        // caller only needs to know about CheckoutFacade,
        // not about PaymentValidator, FraudCheckService, PaymentGateway, or NotificationService
        CheckoutFacade checkoutFacade = new CheckoutFacade();
        checkoutFacade.checkout(order);
    }
}
