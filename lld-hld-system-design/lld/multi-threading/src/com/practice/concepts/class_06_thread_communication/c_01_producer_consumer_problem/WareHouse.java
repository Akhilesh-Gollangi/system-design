package com.practice.concepts.class_06_thread_communication.c_01_producer_consumer_problem;

public class WareHouse {

    private int productCount;

    private boolean hasProduct=false;

    //In synchronized THread.sleep() holds the lock with it
    // Where wait leaves the lock so other thread will work
    // we have 2 synchronized, if t1 came takeProduct and execute critical section, t1 has acquired lock
    // context switched t2 running came putProduct but it is wating as t1 has lock
    // but intially has product is false, t1 call wait, so t1 releases lock and wait context swithced
    // so t2 get chance it fill the stock and make hasProduct true then notify
    // notify will notify one of the waiting thread, as t1 is waiting here, it notified it will start work, t1 takes the product

    public synchronized void takeProduct() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Came to take product from warehouse");
        if (!hasProduct) {
            System.out.println("Product is out of stock, waiting for stock in");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " took the product we wanted");
        hasProduct=false;
        notify();
    }

    //if t2 comes putProduct first and acquired the lock, so t1 will wait.as t2 donot have stock it will create stock and notify
    // waiting thread which t1 then t1 consume the product. like this producer and consumer works

    public synchronized void putProduct(int product) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Came to put product in warehouse");
        if (hasProduct) {
            System.out.println("Product is full stock, waiting to complete so we can refill stock");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " putted the product");
        product=1;
        hasProduct=true;
        notify();
    }
}
