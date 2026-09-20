package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_completable_futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    // we have scenario

    // get number

    // double it

    // print it

    // we will do with futures
    public static void main(String[] args) {

        //instead of we doing chaining stuff we use CompletableFuture

        // this supplyAsync takes supplier and return CompletableFuture
        CompletableFuture<Integer> getNumber = CompletableFuture.supplyAsync(new GetNumber());

        // this thenApply takes Function and return CompletableFuture
        CompletableFuture<Integer> doubleNumber = getNumber.thenApply(new DoubleNumber());

        // these are internal using FunctionalInterfaces
        // we are not passing any values right?
        // getNumber,doubleNumber these will have values, we donot need to pass explicitly

        doubleNumber.thenAccept(new PrintNumber());

        // we can simplify

        CompletableFuture.supplyAsync(new GetNumber())
                .thenApply(new DoubleNumber())
                .thenAccept(new PrintNumber());

        // in future we are doing all the thing, but here CompletableFuture has methods
        // to internal handle those things

        //CompletableFuture actually use Functional Interfaces internally

        CompletableFuture.supplyAsync(() -> 100)
                .thenApply((x) -> x * 2)
                .thenAccept(System.out::println);

    }

}
