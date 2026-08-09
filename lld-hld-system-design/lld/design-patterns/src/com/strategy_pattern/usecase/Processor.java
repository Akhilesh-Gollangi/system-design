package com.strategy_pattern.usecase;

public class Processor {

    private ICategory category;

    private IPrice price;

    public Processor(ICategory category, IPrice price) {
        this.category = category;
        this.price = price;
    }

    public void setCategory(ICategory category) {
        this.category = category;
    }

    public void setPrice(IPrice price) {
        this.price = price;
    }

    public void process() {
        category.getCategory();
        price.getPrice();
    }

}
