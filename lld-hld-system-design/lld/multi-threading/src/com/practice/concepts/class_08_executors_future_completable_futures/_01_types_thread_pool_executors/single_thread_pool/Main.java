package com.practice.concepts.class_08_executors_future_completable_futures._01_types_thread_pool_executors.single_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Instead of we are creating ThreadPool with lot of  the params
        // ExecutorService is like a factory which will take
        // minimum params and creates thread pool

        // This core size and max size as 1, so we can have only one thread running all tasks
        // keepalive time 0 and unbounder queue
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executor.execute(new MyTask(i));
        }

        // this is mandtory, we have to close it otherwise code will not end
        executor.shutdown();

    }
}
