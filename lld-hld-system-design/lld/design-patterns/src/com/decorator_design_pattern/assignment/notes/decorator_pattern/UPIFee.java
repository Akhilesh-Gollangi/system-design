package com.decorator_design_pattern.assignment.notes.decorator_pattern;

public class UPIFee implements IFeeStrategy{

    @Override
    public void deductFee() {
        System.out.println("deduct UPI fine");
    }
}
