package com.practice.concepts.class_08_executors_future_completable_futures._02_futures;

import java.util.Date;
import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + " Stated summation");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        int sum = 10 + 20;
        System.out.println(Thread.currentThread().getName() + " Done Summation took (sec)= " + ((System.currentTimeMillis() - start) / 1000));
        return sum;
    }
}
