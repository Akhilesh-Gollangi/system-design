package com.practice.concepts.class_03_remaing_states_syncronized_race_condition.timed_waiting;

public class TimedWaitingMain {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyTask();
        Thread thread = new Thread(runnable,"sleeping_thread");
        // we want to print TIMED_WAITING
        // When thread is sleeping for particular amount of time that means that thread is in TIMED_WAITING
        //thread has sleep of 3s
        thread.start();

        System.out.println(thread.getState());
        // Did we get TIMED WAITING HERE
        // may or may not
        //we may get RUNNABLE or TIMED_WAITING based on os(jvm)
        // if main thread get chance to run getstate before thread actual call the sleep, we end up in running
        // but we can force jvm to pick thread how?
        // when main thread has sleep for short time, when main thread will sleep
        // so jvm assign thread to CPU, as core is getting idle
        // so thread will execute sleep
        // then again main thread get chance it will execute state, at this point thread already triggered
        //sleep so it will be in TIMED_WAITING
        Thread.sleep(100);
        System.out.println(thread.getState());

    }
}
