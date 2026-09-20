package com.practice.concepts.class_07_threadpool_executor.e_1_default_thread_pool_creation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * EXPERIMENT 1 - ONLY CORE THREADS
 *
 * CONFIG
 *   corePoolSize = 2, maximumPoolSize = 5, queue = ArrayBlockingQueue(3)
 *   tasks submitted = 2
 *
 * WHAT IS BEING TESTED
 *   What the pool does when the work fits inside the core threads.
 *
 * WHAT TO WATCH
 *   - two different worker thread names in the output
 *   - both tasks start immediately, neither waits
 *   - queued stays 0 the whole time
 *
 * EXPECTED
 *   poolSize grows 0 -> 1 -> 2 and stops. maximumPoolSize is never approached,
 *   because a worker is only created while poolSize < corePoolSize.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // core pool size is 2 number of threads we have initially
        // max pool size is 5 upto number of threads it can increase
        // keepAlivetime suppose if the threads has 3 threads
        // but core size is 2 we have extra thread which is idle
        // we will always maintain of core poolsize if there is no task
        // so we have to kill extra threads which are idle, but instead of kill directly
        // there is chance again task will come right, so we will wait some time then we kill it
        // that time is keep alive time
        // queue when 2 threads are busy we get r3, so it will be stored in queue
        // then r4,r5 comes stored, when r6 comes queue is full, but max pool size is 5 we have only 2 threads running
        // then jvm creates new thread t3 which pick r6
        // after completing task t3 picks tasks in queue
        // the threads which complete the work as well pick task from queue

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3)
        );
        for (int i = 1; i <= 2; i++) {
            threadPoolExecutor.execute(new MyTask(i));
            Thread.sleep(10);
            System.out.println("task : " + i + " Submitted task");
            print(threadPoolExecutor);
        }

        Thread.sleep(1000);

        System.out.print("Before Termination : ");
        print(threadPoolExecutor);

        // after using threadPoolExecutor we should do shoutdown, then it will not take any new tasks
        // otherwise it will be waiting for new task, code will never stop
        threadPoolExecutor.shutdown();

        // if you want all the waiting threads to be killed
        // that means if you do shutdown it will not new task
        // but existing threads will still run, to kill the existing running threads
        // after some time, we use this
        threadPoolExecutor.awaitTermination(10, TimeUnit.MILLISECONDS);

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
