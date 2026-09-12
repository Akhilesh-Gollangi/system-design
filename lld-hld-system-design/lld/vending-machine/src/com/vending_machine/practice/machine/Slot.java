package com.vending_machine.practice.machine;

import com.vending_machine.practice.machine.exception.ProductUnavailableException;

public class Slot {

    private String slotId;

    private String productName;

    private double price;

    private int quantity;

    public Slot(String id, String productName, double price, int quantity) {
        this.slotId = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean hasStock() {
        return this.quantity > 0;
    }

    public void dispense() {
        if(this.quantity<=0) {
            throw new ProductUnavailableException("Product you select is not Available");
        }
        this.quantity-=1;
    }
}
