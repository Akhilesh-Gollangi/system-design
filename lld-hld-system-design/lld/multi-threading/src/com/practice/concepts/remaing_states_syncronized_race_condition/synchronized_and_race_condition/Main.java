package com.practice.concepts.remaing_states_syncronized_race_condition.synchronized_and_race_condition;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // if 2persons working on same counter
        // suppose it will count for 5
        // if 2 persons are working on it, it will become 10
        // both the persons working on same counter

        // 2 persons are 2 threads, take count as 1000
        NormalCounter normalCounter = new NormalCounter(0);
        NormalCounterRunnable normalCounterRunnable = new NormalCounterRunnable(normalCounter);
        Thread thread1 = new Thread(normalCounterRunnable, "NORMAL_THREAD_1");
        Thread thread2 = new Thread(normalCounterRunnable, "NORMAL_THREAD_2");
        thread1.start();
        thread2.start();

        //I have to print count, after both threads are completely executed, so i use join
        thread1.join();
        thread2.join();

        // Did we get 2000
        // one person doing 1000counts and another person doing 1000
        // so ideally we have to get 2000, but did we get that
        // No, sometimes we get 2000, sometimes not
        // Why is this happened
        // count is 0
        // thread1 reads count as 0 and incremented by 1, write count as 1 then context switched
        // thread2 reads count as 1 and incremented by 1, write count as 2 then context switched
        // thread1 reads count as 2 and incremented by 1, write count as 3 then context switched
        // thread2 reads count as 3 and incremented by 1, write count as 4 then context switched
        // thread1 reads count as 4 then context switched
        // thread2 reads count as 4 and context switched
        // thread1 already reads count as 4 so it incremented by 1, write count as 5 then context switched
        // thread2 already reads count as 4 so it incremented by 1, write count as 5 then context switched

        // we loss count here, like this it will happen often, so we see Inconsistency in the count
        // This will occur frequently in multi threading
        // Similar In Singleton
        /*
            if(instance==null) {
               instance = new ClassA();
            }
         */
        // Here as well we have 2 threads
        // first thread access instance null, check condition it is true context switch
        // second thread access instance null, check condition it is true context switch
        // First thread as it already check the condition, it will do next step create object and context switch
        // Second thread also already check the condition, it will do next step create object and context switch
        // Singleton main idea to create one object , but we ended up creating 2


        System.out.println("Normal Count: "+normalCounter.getCount());

        // This will occur frequently in multi threading

        // THis is called race condition
        // Multiple threads are racing to finish the task,which leads to inconsistency
        // instance==null is race condition
        // this block is critical block where check and update happens
        /*
            if(instance==null) {
               instance = new ClassA();
            }
         */
        // To avoid this Synchronized comes it picture
        // when we apply Synchronized on critical block
        // This will make sure only one thread to access the critical block at point until it's completion
        // if context switched other threads do other task
        // There is chance another thread is waiting for same critical block
        // which means that thread in BLOCKED state

        SynchronziedCounter synchronziedCounter = new SynchronziedCounter(0);
        Runnable synchronizedCounterRunnable = new SynchronizedCounterRunnable(synchronziedCounter);
        Thread t1 = new Thread(synchronizedCounterRunnable,"SYNC_THREAD_1"); // we can give thread name in constructor
        Thread t2 = new Thread(synchronizedCounterRunnable,"SYNC_THREAD_1");

        t1.start();
        t2.start();

        //we will call main thread sleep so, it will allows other threads to execute
        Thread.sleep(100);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        // one thread will be TIMED_WAITING
        // another thread will be BLOCKED
        // because when main thread is sleep
        // jvm pick t1 or t2, think it pick t1 so,it got critical block which is synchronied
        // so t1 has sleep as well while t1 is in sleep jvm pick t2. but t1 executing that synchronzied block
        // t2 has to wait until t1 got completed, so t2 is in blocked state
        // if you get t1 runnable increase sleep in t1

        t1.join();
        t2.join();


        System.out.println("Synchronized count : "+ synchronziedCounter.getCount());


        // for bigger the count, we find more differece to understand





    }
}
