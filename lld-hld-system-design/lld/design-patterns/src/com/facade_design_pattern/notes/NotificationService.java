package com.facade_design_pattern.notes;

public class NotificationService {

    public void sendReceipt(Order order) {
        System.out.println("sending receipt for amount: " + order.getAmount());
    }
}
