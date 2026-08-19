package com.decorator_design_pattern.decorator_with_strategy.notes.decorator_pattern;

public class CardFee implements IFeeStrategy {
    @Override
    public void deductFee() {
        System.out.println("deduct card fine");
    }
}
