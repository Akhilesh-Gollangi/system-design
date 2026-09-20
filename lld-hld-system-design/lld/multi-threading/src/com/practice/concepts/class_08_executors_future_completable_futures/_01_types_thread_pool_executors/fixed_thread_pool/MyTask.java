package com.practice.concepts.class_08_executors_future_completable_futures._01_types_thread_pool_executors.fixed_thread_pool;

public class MyTask implements Runnable{

    private int task;

    public MyTask(int i) {
        this.task=i;
    }
    @Override
    public void run() {
        System.out.println("Task - "+task+" Running : "+ Thread.currentThread().getName());
    }
}
