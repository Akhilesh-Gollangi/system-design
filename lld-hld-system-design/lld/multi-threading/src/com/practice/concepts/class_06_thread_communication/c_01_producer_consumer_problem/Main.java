package com.practice.concepts.class_06_thread_communication.c_01_producer_consumer_problem;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Suppose think we have Synchronized block in that we have Thread.sleep()
        // we have t1,t2 2 threads acting on same object, if t1 accessed Synchronized block and
        // acquired lock and then Thread.sleep
        // will t1 release then lock ? No

        // That's where wait comes to picture
        // instead of t1 doing Thread.sleep() if t1 call wait then that
        // t1 will wait and t2 start executes
        // but who will tell t1 to start again
        // after t2 completes it task it will call notify this will awake waiting thread
        // here t1 will awake

        // Suppose we have 2 independent methods in a class
        // we have 2 threads so f2 accessed by t2 first and acquired lock
        // then t1 has to wait as object has one lock it is already acquired by t1
        // t1 has to wait until t2 complete and release the lock and then cpu will decide to awake or not
        //  but using wait and notify, t1 will notified awaked  once t2 is completed
        // so it we are blocking, which is the wait and notify

        // sleep will holds the lock where wait will release lock


        // if we have t1,t2,t3,t4 multiple threads in waiting, if we another t5 thread which call notify
        // can i specify to awake t2 using notify
        // you cannot do it, notify randomly pick a thread and start working
        // if you all the threads to awake once use notify all


        // producer consumer problem

        // we have producer, factory, consumer
        // if there are no items in factory will consumer consumes ? NO
        // if factory is full will producer need produce ? No
        // factory is single resource both producer and consumer works on this product putitem (function) (coding)
        // and cosumer takeitem (function) both are synchronzied (coding)
        // we have empty factory then consumer thread came acquired lock, as  empty factory it will wait, releases lock
        // in same factory then producer thread came acquired lock and put item, if it is keep on putting items
        // that will leads to full right. so when producer put food it will notify
        // so waiting thread which is consumer awakens and consumes the item. this wait and notify is based on a logic

        WareHouse wareHouse = new WareHouse();
        Producer producer = new Producer(wareHouse, 1);
        Consumer consumer = new Consumer(wareHouse);

        Thread t1 = new Thread(producer, "producer");
        Thread t2 = new Thread(consumer, "consumer");

        t2.start();
        t1.start();

    }
}
