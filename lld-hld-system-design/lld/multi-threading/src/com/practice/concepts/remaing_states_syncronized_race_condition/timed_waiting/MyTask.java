package com.practice.concepts.remaing_states_syncronized_race_condition.timed_waiting;

public class MyTask implements Runnable {

    public void print() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        System.out.println("Task Executed by : " + Thread.currentThread().getName());

    }

    @Override
    public void run() {
        print();
    }
}
