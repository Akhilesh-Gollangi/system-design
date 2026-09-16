package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.c_04_reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    Lock lock = new ReentrantLock();

    public void outer() {
        System.out.println(Thread.currentThread().getName() + " : Entered outter block");

        lock.lock();
        System.out.println(Thread.currentThread().getName() + " : acquired lock outter block");
        try {
            Thread.sleep(1000);
            inner();
        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            System.out.println(Thread.currentThread().getName() + " : released lock of outter block");
            lock.unlock();
        }

    }

    public void inner() {
        System.out.println(Thread.currentThread().getName() + " : Entered Inner block");

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : acquired lock inner block");
        } finally {
            System.out.println(Thread.currentThread().getName() + " : released lock of inner block");

            lock.unlock();
        }
    }
}
