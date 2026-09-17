package com.practice.concepts.class_06_thread_communication.c_01_producer_consumer_problem;

public class Consumer implements Runnable {

    private final WareHouse wareHouse;

    public Consumer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                wareHouse.takeProduct();
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }

        }
    }
}
