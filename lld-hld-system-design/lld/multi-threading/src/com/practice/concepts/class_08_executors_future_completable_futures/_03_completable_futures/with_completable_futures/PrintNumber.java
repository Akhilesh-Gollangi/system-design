package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_completable_futures;

import java.util.function.Consumer;

public class PrintNumber implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {
        System.out.println("Number : " + integer);
    }
}
