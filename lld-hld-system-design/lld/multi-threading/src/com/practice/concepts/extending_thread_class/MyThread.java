package com.practice.concepts.extending_thread_class;

//we can create threads in 2ways
// By extending thread class which we are doing here
public class MyThread extends Thread {

    public void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Current Thread : " + Thread.currentThread().getName());

            System.out.println("Performing Task");
        }
    }


    //This will specify the thread, what it has to do
    @Override
    public void run() {
        print();
    }
}
