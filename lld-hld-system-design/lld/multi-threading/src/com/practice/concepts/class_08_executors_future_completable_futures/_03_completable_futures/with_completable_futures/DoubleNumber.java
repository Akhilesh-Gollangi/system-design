package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_completable_futures;

import java.util.function.Function;

public class DoubleNumber implements Function<Integer,Integer> {
    @Override
    public Integer apply(Integer integer) {
        return 2 * integer;
    }
}
