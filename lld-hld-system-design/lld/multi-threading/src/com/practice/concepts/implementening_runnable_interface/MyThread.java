package com.practice.concepts.implementening_runnable_interface;

public class MyThread implements Runnable {

    private void print() {
        System.out.println("Task Execution started " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println(i+ " Task Executed by : " + Thread.currentThread().getName());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Task Finished by "+ Thread.currentThread().getName());
    }

    @Override
    public void run() {
        print();
    }
}
