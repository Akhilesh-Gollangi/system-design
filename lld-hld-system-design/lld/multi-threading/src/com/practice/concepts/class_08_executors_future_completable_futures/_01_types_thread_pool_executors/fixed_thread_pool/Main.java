package com.practice.concepts.class_08_executors_future_completable_futures._01_types_thread_pool_executors.fixed_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Instead of we are creating ThreadPool with lot of  the params
        // ExecutorService is like a factory which will take
        // minimum params and creates thread pool

        // Fixed thread pool has core and max pool size is equal
        // here this will have only 3 threads, as we specified 3
        // keepAlive time is 0 and Unbounded queue
        // queue will grow until the infinite
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executor.execute(new MyTask(i));
        }

        // this is mandtory, we have to close it otherwise code will not end
        executor.shutdown();

    }
}
