package com.practice.concepts.class_05_implict_and_explict_locks.explict_locks.try_lock_with_timmer;

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

        // so critical section is not just for skipping, it has logic to execute so when we cannot skip everytime
        // if db is taking moretime due to someload, then t1 came it is taking more time
        // t2 is blocked, if we have multiple threads all will be blocked until t1 release lock
        // this might lead to app crash,  so instead of waiting they are skipped
        // but instead of skip directly, we can make thread to wait for some particular time
        // tryLock(time, unit) will support this
        // so will skip when t1 is taking more than 10sec, which means db is in load
        // if t1 completed with in 10sec, t2 get lock and execute critical section

        Counter counter = new Counter(0);
        Runnable counterRunnable = new CounterRunnable(counter);
        Thread t1 = new Thread(counterRunnable,"t1");
        Thread t2 = new Thread(counterRunnable,"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count : "+ counter.getCount());


    }
}
