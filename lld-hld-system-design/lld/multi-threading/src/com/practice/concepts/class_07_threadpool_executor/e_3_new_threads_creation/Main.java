package com.practice.concepts.class_07_threadpool_executor.e_3_new_threads_creation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * EXPERIMENT 3 - QUEUE FULL, THEN EXTRA THREADS
 *
 * CONFIG
 *   corePoolSize = 2, maximumPoolSize = 5, queue = ArrayBlockingQueue(3)
 *   tasks submitted = 8, each sleeping 4 seconds
 *
 * WHAT IS BEING TESTED
 *   What happens once the queue can take no more.
 *
 * WHAT TO WATCH
 *   - tasks 1,2 start on the two core workers
 *   - tasks 3,4,5 go into the queue (queued = 3, poolSize still 2)
 *   - tasks 6,7,8 cannot be queued, so workers 3,4,5 are created for them
 *   - poolSize reaches 5 and stops
 *
 * EXPECTED - the full ordering rule
 *   1. poolSize < corePoolSize      -> create a worker
 *   2. otherwise try to queue the task
 *   3. queue full and poolSize < max -> create another worker
 *   4. queue full and poolSize = max -> reject (see experiment 4)
 *
 * NOTE
 *   Tasks 6,7,8 start running BEFORE tasks 3,4,5 which were submitted earlier.
 *   Submission order is not execution order.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3)
        );

        for (int i = 1; i <= 8; i++) {
            threadPoolExecutor.execute(new MyTask(i));
            Thread.sleep(10);
            System.out.println("Task - " + i + " Submitted Task");
            print(threadPoolExecutor);
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
