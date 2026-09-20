package com.practice.concepts.class_08_executors_future_completable_futures._01_types_thread_pool_executors.cached_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Instead of we are creating ThreadPool with lot of  the params
        // ExecutorService is like a factory which will take
        // minimum params and creates thread pool

        // CachedPool will have core as 0 and max as MAXVALUE, keepalive time is 60
        // as it is syncrhonous queue it will not store anythng in queue
        // As number of tasks increases threads will increases
        // as number of tasks decreases threads will decrease
        // thread will sit idle of 60sec
        ExecutorService executor = Executors.newCachedThreadPool();

        // this is bad because, thread has to sit idle for 60sec
        // we cannot control creation of threads it will grow
        // threads creation is operation heavy process

        for (int i = 0; i < 50; i++) {
            executor.execute(new MyTask(i));
        }

        // this is mandtory, we have to close it otherwise code will not end
        executor.shutdown();

    }
}
