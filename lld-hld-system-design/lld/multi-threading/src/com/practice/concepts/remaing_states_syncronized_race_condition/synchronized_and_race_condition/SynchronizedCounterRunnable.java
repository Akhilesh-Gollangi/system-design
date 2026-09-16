package com.practice.concepts.remaing_states_syncronized_race_condition.synchronized_and_race_condition;

public class SynchronizedCounterRunnable implements Runnable {

    private final SynchronziedCounter synchronziedCounter;

    public SynchronizedCounterRunnable(SynchronziedCounter synchronziedCounter) {
        this.synchronziedCounter = synchronziedCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            synchronziedCounter.increment();
        }
    }
}
