package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.c_04_reentrantlock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //If we can class with lock object
        // we have 2 function outer and inner
        // In outer method we have lock and unlock and in critical section we call inner method
        // In inner method also we have lock

        // If we have t1,t2 Threads, if  t1 thread get lock of outer function
        // so Object a lock that lock which acquired by t1, so t2 cannot access either outer or inner method
        // as both function has critical section so both the functions has lock
        // But in outer method critical section we are calling inner function, which also has lock
        // Will this work
        // If t1 thread has lock of object, so it can get other lock as well which is in inner method
        // that is the speciality of reentrant lock
        // Reentrant track the all lock, so when we do unlock, we have to do same number of times as we do lock
        // else we got exception
        // If 2 block synchronized then one call other also work like this
        // because synchronized internally use Reentrant lock

        Resource resource = new Resource();
        Thread t1 = new Thread(() -> resource.outer(), "t1");
        Thread t2 = new Thread(() -> resource.inner(), "t2");

        t1.start();
        Thread.sleep(100);
        t2.start();

        /*
        t1 : Entered outter block
        t1 : acquired lock outter block
        t2 : Entered Inner block
        t1 : Entered Inner block
        t1 : acquired lock inner block
        t1 : released lock of inner block
        t1 : released lock of outter block
        t2 : acquired lock inner block
        t2 : released lock of inner block
         */
        // T1 aquired lock of the lock object, t2 did got lock of the lock object
        // As both refering ssame object only one thread can get the lock
        // here t1 get it, after getting lock t1 can do lock multiple times
        // this is speciality of reentrant lock

        // t2 accessing different method, why cannot it access, because we lock.lock()
        // but lock of the lock object already acquired by t1 so it has to wait until t1 release lock


    }
}
