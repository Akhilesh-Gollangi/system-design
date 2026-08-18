package com.adaptor_design_pattern.notes;

public class UPI implements IPayment {

    @Override
    public void pay() {
        System.out.println("paying using UPI");
    }
}
