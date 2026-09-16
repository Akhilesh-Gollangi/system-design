package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.c_03_try_lock_with_timmer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count;

    Lock lock = new ReentrantLock();

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void increment() {

        //tryLock is it will check whether lock is available, if available it will execute critical section
        // first t1 came to critical section, then lock is available, then tryLock return true
        // it will execute critical section
        // then t2 came to critical section, then lock is not available, then tryLock return false
        // then it will wait for particular amount of time as mentioned the skipped
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + " acquired lock");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }

                try {
                    count++;
                } finally {
                    lock.unlock();
                }

            } else {
                System.out.println(Thread.currentThread().getName() + " Skipped as lock is not available");
            }
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

    }
}
