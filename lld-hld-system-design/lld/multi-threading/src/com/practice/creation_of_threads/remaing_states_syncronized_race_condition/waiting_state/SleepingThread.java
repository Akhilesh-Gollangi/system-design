package com.practice.creation_of_threads.remaing_states_syncronized_race_condition.waiting_state;

public class SleepingThread implements Runnable{


    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task Executed by : "+ Thread.currentThread().getName());
    }
}
