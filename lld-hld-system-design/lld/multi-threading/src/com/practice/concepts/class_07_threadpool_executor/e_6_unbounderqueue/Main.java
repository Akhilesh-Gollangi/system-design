package com.practice.concepts.class_07_threadpool_executor.e_6_unbounderqueue;

import java.util.concurrent.*;

/*
 * EXPERIMENT 8 - UNBOUNDED LINKEDBLOCKINGQUEUE
 *
 * CONFIG
 *   corePoolSize = 2, maximumPoolSize = 5
 *   queue = new LinkedBlockingQueue() with NO capacity argument -> effectively unbounded
 *   tasks submitted = 20, each sleeping 2 seconds
 *
 * WHAT IS BEING TESTED
 *   Whether maximumPoolSize still means anything when the queue never fills.
 *
 * WHAT TO WATCH
 *   - queued climbs to 18 and keeps climbing
 *   - poolSize NEVER goes above 2
 *   - workers 3, 4 and 5 are never created, even though max is 5
 *
 * EXPECTED
 *   Extra workers are only created when the queue REFUSES a task. An unbounded
 *   queue never refuses, so step 3 of the ordering rule is never reached and
 *   maximumPoolSize becomes dead configuration.
 *
 * WHY THIS MATTERS
 *   Executors.newFixedThreadPool() uses exactly this shape. Setting a big
 *   maximumPoolSize with an unbounded queue does not give you more workers -
 *   it just lets work pile up in memory instead.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // here we are using LinkedBlockingDeque<>() as queue
        // if we donot specify capactiy it will grow indefinetly, so it called unbounder queue
        // as we are not specifying size, it will grow infintely
        // this will be use as it will not reject

        // but as queue increase memory increase leads to app crash

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>()
        );

        for (int i = 1; i <= 20; i++) {

            threadPoolExecutor.execute(new MyTask(i));
            Thread.sleep(10);
            System.out.println("Task - " + i + " Submitted Task");
            print(threadPoolExecutor);

        }

        // as i said in experiment one, here we have t1,t2 initially
        // we get r1,r2 so both threads are busy
        // we get r3,r4,r5 these will go to queue
        // even n tasks we get those will go to queue, nothing will be rejected
        // queue will increase and no new threads will be created
        // core threads will run all the tasks


        Thread.sleep(4000);
        System.out.print("Before Termination : ");
        print(threadPoolExecutor);
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(100, TimeUnit.MILLISECONDS);
        System.out.print("After Termination : ");
        print(threadPoolExecutor);

        //this is not recommended in production
        // we use bounder queue means queue with fixed capacity
        // it will create new threads after capacity reached until max pool
        // after threads reached max pool and capacity is full then it will reject

    }

    public static void print(ThreadPoolExecutor threadPoolExecutor) {
        System.out.println("Core pool Size : " + threadPoolExecutor.getCorePoolSize() +
                ", Max Pool Size : " + threadPoolExecutor.getPoolSize() +
                ", Queue size : " + threadPoolExecutor.getQueue().size() +
                ", completed taks : " + threadPoolExecutor.getCompletedTaskCount() +
                ", executed tasks : " + threadPoolExecutor.getTaskCount());
    }
}
