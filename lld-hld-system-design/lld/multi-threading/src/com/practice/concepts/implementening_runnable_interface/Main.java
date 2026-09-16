package com.practice.concepts.implementening_runnable_interface;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Entered into main Method");

        // We have created thread here using implemening runnable interface
        // which is better : runnable is better, because multiple inheritance
        // java doesnot support multiple inheritance, so class cannot extend multiple classes
        // If Class A extends Thread then it cannot extend any other classes which is closer to it
        // But if Class A implements thread it can extend the class which is closer to it
        // and class can implement multiple interfaces
        Runnable myThread = new MyThread();
        // If you see Runnable it is Functional Interface which has only 1 abstract method run that's it
        // then how would it create threads which is the reason we are sending runnable object to Thread
        Thread thread = new Thread(myThread);
        // we can setname to a thread
        thread.setName("Akhil");

        //Thread have multiple states
        //NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINTED

        //before calling start thread is in NEW state
        System.out.println(thread.getName()+" current state : " + thread.getState());

        thread.start();

        //After calling start thread is in RUNNABLE State
        System.out.println(thread.getName()+" current state : " + thread.getState());


        // If i want to print 'Ending Main Thread after completing execution' after thread is completely executed
        // then i have to use thread.join()
        // the thread which call thread.join() has to waiting until thread is completed
        // if t2.join() is called by t1 then t1 has to wait until t2 is completed
        // as we want main thread to wait until thread completed we use join
        thread.join();
        // After thread is completed only it will execute main thread
        // we reach here after thread is completed so it is TERMINATED state
        System.out.println(thread.getName()+" current state : " + thread.getState());

        //BLOCKED State when we function  which can be accessed by one thread at a time
        // then the thread which is accessing function is in BLOCKED State

        //WAITING state is when thread.join() is used then main is waiting right
        // it is WAITING State

        // TIMED-WAITING state when we use thread the sleep at that time thread is this state


        Thread thread1 = new Thread(myThread);
        // we created new thread, it means this thread also waits until thread is completed
        // not really thread.join() called by main thread, so jvm stops only main thread
        // other threads will execute concurrently
        thread1.setName("Eshu");
        thread1.start();

        // if i want 'Ending Main Thread after completing execution' this to execute
        // after the thread1 then we add thread1.join()
        thread1.join();
        // here only main thread is waiting

        // even If i add thread.sleep, even core is idle still main thread is waiting
        // until thread is completed
        for (int i = 0; i < 100; i++) {
            System.out.println("Ending Main Thread after completing execution");
        }
    }
}
