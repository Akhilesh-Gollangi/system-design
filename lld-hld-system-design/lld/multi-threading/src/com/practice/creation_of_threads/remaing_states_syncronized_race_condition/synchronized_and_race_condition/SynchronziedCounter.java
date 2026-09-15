package com.practice.creation_of_threads.remaing_states_syncronized_race_condition.synchronized_and_race_condition;

public class SynchronziedCounter {

    private int count;

    public SynchronziedCounter(int n) {
        this.count = n;
    }

    public synchronized void increment() {
        count++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public int getCount() {
        return this.count;
    }
}
