package com.vending_machine.practice.additionalrequirement.trasaction;

import com.vending_machine.practice.additionalrequirement.common.PaymentMethod;

public class Transaction {

    private String slotId;
    private String productName;
    private double price;
    private PaymentMethod paymentMethod;
    private double amountReceived;
    private double changeGiven;
    private long timestamp;

    public Transaction(String slotId, String productName, double price, PaymentMethod paymentMethod,
                       double amountReceived, double changeGiven, long timestamp) {
        this.slotId = slotId;
        this.productName = productName;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.amountReceived = amountReceived;
        this.changeGiven = changeGiven;
        this.timestamp = timestamp;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public double getChangeGiven() {
        return changeGiven;
    }

    public void setChangeGiven(double changeGiven) {
        this.changeGiven = changeGiven;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
