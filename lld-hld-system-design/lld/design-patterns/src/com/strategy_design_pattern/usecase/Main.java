package com.strategy_design_pattern.usecase;

public class Main {
    public static void main(String[] args) {
        Electoronics electoronics = new Electoronics();
        Clothes clothes = new Clothes();

        // here we are calling category of electronics and price of clothes
        Processor processor = new Processor(electoronics,clothes);
        processor.process();

        //Both are electronics now
        processor.setPrice(electoronics);
        processor.process();

        //Both are clothes now
        processor.setCategory(clothes);
        processor.setPrice(clothes);
        processor.process();



    }
}
