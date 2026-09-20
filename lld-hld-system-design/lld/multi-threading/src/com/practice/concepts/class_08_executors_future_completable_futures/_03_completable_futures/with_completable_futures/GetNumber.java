package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_completable_futures;

import java.util.function.Supplier;

public class GetNumber implements Supplier<Integer> {
    @Override
    public Integer get() {
        return 10;
    }
}
