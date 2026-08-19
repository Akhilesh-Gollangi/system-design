package com.decorator_design_pattern.decorator_with_strategy.practice.decorator_with_pament;

public class UPIFee implements IFeeStretegy {
    @Override
    public void feeDeduction() {
        System.out.println("UPI fee has been deducted.");
    }
}