package com.practice.concepts.class_07_threadpool_executor.e_4_queue_rejection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * EXPERIMENT 4 - FULL POOL + FULL QUEUE = REJECTION
 *
 * CONFIG
 *   corePoolSize = 2, maximumPoolSize = 5, queue = ArrayBlockingQueue(3)
 *   rejection policy = AbortPolicy (this is also the default)
 *   tasks submitted = 9, each sleeping 5 seconds
 *
 * WHAT IS BEING TESTED
 *   The capacity of the executor, and what happens one task past it.
 *
 * WHAT TO WATCH
 *   - tasks 1-8 are accepted: 5 running on workers, 3 waiting in the queue
 *   - task 9 is rejected and RejectedExecutionException is thrown to the SUBMITTER
 *
 * EXPECTED
 *   Total capacity = maximumPoolSize + queue capacity = 5 + 3 = 8.
 *   Rejection needs all three at once: pool at max, queue full, another task arriving.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3)
        );

        for (int i = 1; i <= 10; i++) {
            try {
                threadPoolExecutor.execute(new MyTask(i));
                Thread.sleep(10);
                System.out.println("Task - " + i + " Submitted Task");
                print(threadPoolExecutor);
            } catch (RejectedExecutionException e) {
                System.out.println("Task - " + i + " got rejected as queue is full");
            }
        }

        // as i said in experiment one, here we have t1,t2 initially
        // we get r1,r2 so both threads are busy
        // we get r3,r4,r5 these are in queue, no new threads created yet.
        // we get r6 then one new thread created as no of threads is 2 and max pool size is 5
        // jvm can create 3 more
        // so when r6 comes,queue if full and existing threads t1,t2 are busy, so new thread t3 created
        // picks t3 picks r6
        // again r7 comes all exisiting threads busy so t4 created, picks r7
        // again r7 comes all exisiting threads busy so t5 created, picks r8
        // Thread reached maximum size no extra threads will be created
        // Any thread complete it's task it will pick tasks in queue

        // When Thread reached maximum size no extra threads will be created and
        // queue is also full then we get another task then it will be rejected based on Rejection policy

        // All Existing threads are busy and queue is full we get r9, then it will rejected
        // Based on the Rejection policy


        Thread.sleep(4000);
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
