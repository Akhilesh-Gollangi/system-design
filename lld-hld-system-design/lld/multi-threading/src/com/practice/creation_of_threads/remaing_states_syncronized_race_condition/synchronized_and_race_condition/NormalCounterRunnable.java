package com.practice.creation_of_threads.remaing_states_syncronized_race_condition.synchronized_and_race_condition;

public class NormalCounterRunnable implements Runnable {

    private final NormalCounter normalCounter;

    public NormalCounterRunnable(NormalCounter normalCounter) {
        this.normalCounter = normalCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            normalCounter.increment();
        }
    }
}
