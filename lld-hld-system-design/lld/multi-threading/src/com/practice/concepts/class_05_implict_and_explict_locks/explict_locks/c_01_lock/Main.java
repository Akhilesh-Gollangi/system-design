package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.c_01_lock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //synchronized is implict lock, here we donot have any control
        // So then came Explicit locking, where we have control on it
        // It is acheived using Lock Interface
        // It has 2 child Reenterant Lock and ReadWrite lock
        // synchronized internal use Reenterant lock but as it implict we cannot see it
        // Lock provides 3 methods lock, unlock,trylock

        //lock :
        // if we have 2threads working on same counter object c1, when t1 acquired lock of c1
        // then t2 thread is blocked to execute critical section of c1, until t1 releases lock

        // if t1 and t2 are 2 different objects threads of c1 and c2 and then t1 get lock of c1 and
        // t2 get lock of c2, so both threads can access critical section.

        // This is same like synchronized

        LockCounter lockCounter = new LockCounter(0);
        Runnable lockCounterRunnable = new LockCounterRunnable(lockCounter);

        Thread t1 = new Thread(lockCounterRunnable,"t1");
        Thread t2 = new Thread(lockCounterRunnable,"t2");

        t1.start();
        t2.start();

        // we are waiting until both threads to complete then we will print count
        t1.join();
        t2.join();

        System.out.println("Final count : " + lockCounter.getCount());



    }
}
