package com.facade_design_pattern.notes;

public class FraudCheckService {

    public boolean isRisky(Order order) {
        System.out.println("running fraud check for amount: " + order.getAmount());
        return false;
    }
}
