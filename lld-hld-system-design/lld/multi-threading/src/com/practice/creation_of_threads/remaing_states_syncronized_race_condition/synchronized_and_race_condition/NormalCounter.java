package com.practice.creation_of_threads.remaing_states_syncronized_race_condition.synchronized_and_race_condition;

public class NormalCounter {

    private int count;

    public NormalCounter(int n) {
        this.count = n;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return this.count;
    }

}
