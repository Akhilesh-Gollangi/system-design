package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_futures;

import java.util.concurrent.Callable;

public class GetNumber implements Callable<Integer> {

    @Override
    public Integer call() {
        return 10;
    }
}
