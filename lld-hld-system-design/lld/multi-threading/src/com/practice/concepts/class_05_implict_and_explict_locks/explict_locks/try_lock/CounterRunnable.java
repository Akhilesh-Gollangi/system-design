package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.try_lock;

public class CounterRunnable implements Runnable {
    private final Counter counter;

    public CounterRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
        }
    }
}
