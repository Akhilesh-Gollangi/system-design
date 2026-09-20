package com.practice.concepts.class_08_executors_future_completable_futures._02_futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //executor.execute(); this will accept runnable
        // but when we need return type but runnable doesnot return anything
        // then we have to callable, which will return something

        // executor.submit will take runnable or callable
        // if we gave callable it will return
        // but if we do this Integer x = executor.submit(new Sum());
        // we will get compliation error because

        // executor.submit(new Sum()); calls the callable call method
        // think it is doing some expensive operation so it is taking some time
        // we have 2 threads t1 and main.
        // main called submit context switched, but main will expect something as call return something
        // t1 start executing call but expensive operation taking time
        // context switched but t1 did not return anything,
        // so main thread cannot store anything in x, so it will cause issue

        // So Future comes, main will store the value in future and move to next steps
        // then context switches happen both will work
        // if call return then fine else still t1 has some tasks
        // then when main do x.get() then main will stop blocked, until t1 completes the task
        // and return something, until that main will be blocked


        Future<Integer> sum =  executor.submit(new Sum());
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+" is getting sum from t1 thread");
        // main will blocker here, until t1 return something
        System.out.println(sum.get());

        executor.shutdown();


    }
}
