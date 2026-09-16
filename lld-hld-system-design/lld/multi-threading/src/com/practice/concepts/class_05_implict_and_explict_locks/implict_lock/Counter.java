package com.practice.concepts.class_05_implict_and_explict_locks.implict_lock;

public class Counter {

    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public synchronized void increment() {
        count++;
    }
}
