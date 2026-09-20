package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_futures;

import java.util.concurrent.Callable;

public class PrintNumber implements Callable<Integer> {

    private int x;

    public PrintNumber(int x) {
        this.x=x;
    }


    @Override
    public Integer call() {
        System.out.println("Number : "+x);
        return x;
    }
}
