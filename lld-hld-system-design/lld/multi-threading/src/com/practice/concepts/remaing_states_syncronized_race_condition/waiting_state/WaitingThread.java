package com.practice.concepts.remaing_states_syncronized_race_condition.waiting_state;

public class WaitingThread implements Runnable{

    private final Thread threadToWaitFor;

    public WaitingThread(Thread threadToWaitFor) {
        this.threadToWaitFor = threadToWaitFor;
    }

    @Override
    public void run() {
        System.out.println("Started waiting by : "+ Thread.currentThread().getName());
        try {
            threadToWaitFor.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        System.out.println("Enough Waiting by : "+ Thread.currentThread().getName());
    }
}
