package com.strategy_pattern.usecase;

public class Clothes implements ICategory, IPrice{

    @Override
    public void getCategory() {
        System.out.println("Clothese");
    }

    @Override
    public void getPrice() {
        System.out.println("PRICE : 2000");
    }
}
