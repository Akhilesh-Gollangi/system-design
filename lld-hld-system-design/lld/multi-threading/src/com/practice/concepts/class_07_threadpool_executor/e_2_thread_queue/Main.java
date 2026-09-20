package com.practice.concepts.class_07_threadpool_executor.e_2_thread_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * EXPERIMENT 2 - QUEUE BEFORE EXTRA THREADS
 *
 * CONFIG
 *   corePoolSize = 2, maximumPoolSize = 5, queue = ArrayBlockingQueue(3)
 *   tasks submitted = 5, each sleeping 3 seconds
 *
 * WHAT IS BEING TESTED
 *   Whether the pool creates a third worker as soon as the core threads are busy.
 *   It does not.
 *
 * WHAT TO WATCH
 *   - only tasks 1 and 2 print STARTED at first
 *   - tasks 3, 4 and 5 sit in the queue (queued climbs to 3)
 *   - poolSize stays at 2 even though maximumPoolSize is 5
 *
 * EXPECTED
 *   The queue is filled BEFORE any extra worker is created. Extra workers are a
 *   last resort, not the first reaction to busy core threads.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3)
        );

        for (int i = 1; i <= 5; i++) {
            threadPoolExecutor.execute(new MyTask(i));
            Thread.sleep(10);
            System.out.println("Task - " + i + " Submitted Task");
            print(threadPoolExecutor);
        }

        // as i said in experiment one, here we have t1,t2 initially
        // we get r1,r2 so both threads are busy
        // we get r3,r4,r5 these are in queue, no new threads created yet.
        // when t1,t2 complete it's work then it will pick something from queue

        Thread.sleep(7000);
        System.out.print("Before Termination : ");
        print(threadPoolExecutor);
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(100, TimeUnit.MILLISECONDS);

        System.out.print("After Termination : ");
        print(threadPoolExecutor);

    }

    public static void print(ThreadPoolExecutor threadPoolExecutor) {
        System.out.println("Core pool Size : " + threadPoolExecutor.getCorePoolSize() +
                ", Max Pool Size : " + threadPoolExecutor.getPoolSize() +
                ", Queue size : " + threadPoolExecutor.getQueue().size() +
                ", completed taks : " + threadPoolExecutor.getCompletedTaskCount() +
                ", executed tasks : " + threadPoolExecutor.getTaskCount());
    }
}
