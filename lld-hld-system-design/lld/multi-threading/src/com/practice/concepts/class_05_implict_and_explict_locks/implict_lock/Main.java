package com.practice.concepts.class_05_implict_and_explict_locks.implict_lock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // we make critical block synchronized so that
        // one thread of a same object can access the lock once

        Counter counter = new Counter(0);
        Runnable counterRunnable = new CounterRunnable(counter);
        Thread t1 = new Thread(counterRunnable,"t1");
        Thread t2 = new Thread(counterRunnable,"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count : "+ counter.getCount());

    }
}
