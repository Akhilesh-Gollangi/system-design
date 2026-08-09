package com.strategy_pattern.usecase;

public class Electoronics implements  ICategory,IPrice{
    @Override
    public void getCategory() {
        System.out.println("Electornics");
    }

    @Override
    public void getPrice() {
        System.out.println("PRICE : 10000");
    }
}
