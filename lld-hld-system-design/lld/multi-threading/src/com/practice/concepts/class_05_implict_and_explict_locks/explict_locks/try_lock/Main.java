package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.try_lock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //synchronized is implict lock, here we donot have any control
        // So then came Explicit locking, where we have control on it
        // It is acheived using Lock Interface
        // It has 2 child Reenterant Lock and ReadWrite lock
        // synchronized internal use Reenterant lock but as it implict we cannot see it
        // Lock provides 3 methods lock, unlock,trylock

        //tryLock :
        //tryLock is it will check whether lock is available, if available it will execute critical section
        // first t1 came to critical section, then lock is available, then tryLock return true
        // it will execute critical section
        // then t2 came to critical section, then lock is not available, then tryLock return false
        // then that will be skipped

        // if db is taking moretime due to someload, then t1 came it is taking more time
        // t2 is blocked, if we have multiple threads all will be blocked until t1 release lock
        // this might lead to app crash, so instead of waiting they are skipped

        Counter counter = new Counter(0);
        Runnable counterRunnable = new CounterRunnable(counter);
        Thread t1 = new Thread(counterRunnable,"t1");
        Thread t2 = new Thread(counterRunnable,"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count : "+ counter.getCount());

        // so crictial section is not just for skipping, it has logic to execute so when we have to skip
        // if db is taking moretime due to someload, then t1 came it is taking more time
        // t2 is blocked, if we have multiple threads all will be blocked until t1 release lock
        // this might lead to app crash,  so instead of waiting they are skipped
        // so we use tryLock with time refer try_lock_with_timmer package
    }
}
