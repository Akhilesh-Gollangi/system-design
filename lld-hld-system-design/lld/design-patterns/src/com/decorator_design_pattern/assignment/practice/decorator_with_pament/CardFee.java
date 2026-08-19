package com.decorator_design_pattern.assignment.practice.decorator_with_pament;

public class CardFee implements IFeeStretegy {
    @Override
    public void feeDeduction() {
        System.out.println("Card fee has been deducted.");
    }
}