package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

    private int count;

    Lock lock = new ReentrantLock();

    public LockCounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    // instead of marking synchronized, we can acheive lock using Reentrant lock as well
    public void increment() {
        // if we have 2threads working on same counter object c1, when t1 acquired lock of c1
        // then t2 thread is blocked to execute critical section of c1, until t1 releases lock

        // if t1 and t2 are 2 different objects threads of c1 and c2 and then t1 get lock of c1 and
        // t2 get lock of c2, so both threads can access critical section.

        // This is same like synchronized
        try {
            System.out.println(Thread.currentThread().getName()+" acquired lock");
            lock.lock();
            count++;
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" release lock");
        }
    }
}
