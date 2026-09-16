package com.practice.concepts.class_05_implict_and_explict_locks.implict_lock;

public class CounterRunnable implements Runnable {
    private final Counter counter;

    public CounterRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            counter.increment();
        }
    }
}
