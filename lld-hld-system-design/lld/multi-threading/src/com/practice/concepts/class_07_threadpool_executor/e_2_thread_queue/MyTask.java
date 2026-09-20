package com.practice.concepts.class_07_threadpool_executor.e_2_thread_queue;

public class MyTask implements Runnable {

    private int task;

    public MyTask(int task) {
        this.task = task;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Started task-" + task + " Execution");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        System.out.println(Thread.currentThread().getName() + " Done task-" + task + "  Execution");

    }
}
