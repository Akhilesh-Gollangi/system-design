package com.practice.creation_of_threads.extending_thread_class;

public class Main {

    public static void main(String[] args) {

        // here threads are executing concurrently
        // in single core multiple tasks are running by context switching
        // but any point of time only thread will execute
        // if core is idle or after certain time other threads takes core
        // so everytask make some progress
        // in sequential if i have 10 independent tasks 10th task has to wait until completion of 9
        // in concurrent it will started and make some progress


        // program : set of instruction, java code
        // process : java code which is executing in CPU
        // thread : Path of execution, who will take process to CPU, thread will do that
        // A process have multiple threads, threads share same resource
        // Java threads are nothing but normal threads OS, Java provide a way to create Threads


        //We are printing this using main thread which is default thread
        System.out.println("Entered into class " + Thread.currentThread().getName());

        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();

        // this is sequential way doing thing
        thread.print();
        thread.print();

        //if you want to do in concurrent way, we have to create threads
        // we have created thread by extending thread class
        // but did threads really created no
        thread.run(); // this means method call
        // we didnot actaul create threads yet
        // start() is called then threads are created and assigned to os to assign to CPU
        // start is like template method which have logic to create thread and call run
        // run specify what has do, run method is defined the child classes
        thread.start();

        // if you want to create thread again
//        thread.start(); you cannot do this
        thread1.start();

        //thread will execute, when os assign it to core,
        // os will assign randomly, we can give prirority
        // still os will decide which one execute

        // here threads are executing concurrently
        // in single core multiple tasks are running by context switching
        // but any point of time only thread will execute

        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello World");
        }
    }
}
