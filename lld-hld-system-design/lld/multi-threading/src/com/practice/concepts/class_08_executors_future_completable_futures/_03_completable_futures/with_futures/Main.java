package com.practice.concepts.class_08_executors_future_completable_futures._03_completable_futures.with_futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    // we have scenario

    // get number

    // double it

    // print it

    // we will do with futures

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // by using futures we have to do all the chaining of stuff and execute next steps
        // instead if we doing boilerplate code
        // we can use CompletableFuture which will do chaining stuff internall
        Future<Integer> number = executor.submit(new GetNumber());
        if (number.get() > 0) {
            System.out.println("Successfully retrieved number: " + number.get());

            Future<Integer> doubleNumber = executor.submit(new DoubleNumber(number.get()));
            if (doubleNumber.get() > 0) {
                System.out.println("Successfully doubled the number: " + doubleNumber.get());

                Future<Integer> print = executor.submit(new PrintNumber(doubleNumber.get()));
                System.out.println("Successfully printed the number.");

            }
        }
        executor.shutdown();
    }
}
