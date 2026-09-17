package com.practice.concepts.class_06_thread_communication.c_01_producer_consumer_problem;

public class Producer implements Runnable{

    private final WareHouse wareHouse;
    private int product;

    public Producer(WareHouse wareHouse, int product) {
        this.wareHouse = wareHouse;
        this.product = product;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                wareHouse.putProduct(product);
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }

        }
    }
}
