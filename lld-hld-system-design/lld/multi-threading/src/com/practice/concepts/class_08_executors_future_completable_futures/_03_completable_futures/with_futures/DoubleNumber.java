package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_futures;

import java.util.concurrent.Callable;

public class DoubleNumber implements Callable<Integer> {

    private int x;

    public DoubleNumber(int x) {
        this.x = x;
    }

    @Override
    public Integer call() {
        return 2 * x;
    }
}
