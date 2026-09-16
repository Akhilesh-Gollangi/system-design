package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.c_01_lock;

public class LockCounterRunnable implements Runnable {
    private final LockCounter counter;

    public LockCounterRunnable(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            counter.increment();
        }
    }
}
