package com.practice.concepts.class_03_remaing_states_syncronized_race_condition.waiting_state;

public class WaitingMain {

    public static void main(String[] args) throws InterruptedException {

        // NOW we focus on WAITING
        // if one thread1 is waiting for thread2 to complete means thread1 is in waiting state
        // how do we achieve this
        // we will have 2 threads, in t1 we will call t2.join so, t1 will wait until t2 is completed
        // we will have sleep in t2 so it will in timed waiting state

        Runnable sleepingThread = new SleepingThread();
        Thread t1 = new Thread(sleepingThread, "SLEEPING_THREAD");
        Runnable waitingThread = new WaitingThread(t1);
        Thread t2 = new Thread(waitingThread,"WAITING_THREAD");

        t1.start();
        t2.start();


        // Did we get TIMED WAITING HERE
        // may or may not
        //we may get RUNNABLE or WAITING based on os(jvm)
        // if main thread get chance to run getstate before threads actual call the join and sleep, we end up in running
        // but we can force jvm to pick thread how?
        // when main thread has sleep for short time, when main thread will sleep
        // so jvm assign t1 ot t2 to CPU, as core is getting idle
        // if t2 get chance it will read join so it will wait until t1 completed so WAITING STATE
        // t1 will call sleep this will in TIMED_WAITING
        // then again main thread get chance it will execute state, at this point t1 already triggered
        // as t1 is already sleeping , t2 has to wait until it completed

        //we add small interval of sleep, so other threads gets chance to execute
        Thread.sleep(100);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
