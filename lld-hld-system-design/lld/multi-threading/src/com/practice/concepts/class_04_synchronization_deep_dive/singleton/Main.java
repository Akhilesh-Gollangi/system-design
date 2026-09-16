package com.practice.concepts.class_04_synchronization_deep_dive.singleton;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //first refer bankaccount package


        // how synchronization internal works

        // if t1 and t2 working on same bankaccount
        // t1 reads balance context switched and then t2 reads balance context switched
        // as amount is greater than balance
        // t1 check condition context switched and then t2 check condition context switched
        // if i have balance 1000 and withdraw is 700
        // then t1 withdraw 700 so balance is 300 context switched
        // t2 already passed condition it will continue withdraw of 700 from balace 300
        // we end up in -400 which is correct

        // To avoid this we use Synchronized keyword which will allow only thread can work at a time
        // Is this statement completely true, No
        // t1 and t2 working on same object
        // when t1 comes to Synchronized block it will acquire lock corresponding to that object.
        // locks are based on object, when t2 came to same block, it require lock to run in Synchronized block
        // but as lock is already acquired by t1, t2 has to wait until t1 releases lock
        // This is the reason only one thread of an object can run in synchronized block


        // if t1 and t2 working different bank account b1 and b2
        // t1 reads the b1 balance and withdraw the amount and t2 reads b2 balance and with draw amount

        // In this t1 comes to Synchronized block it will acquire lock corresponding to that object b1
        // then t2 comes to Synchronized block it will acquire lock corresponding to that object b2
        // so both the threads work in Synchronized block as they are different object which have different locks


        // we are making Synchronized function, we will end up like synchronization, if we do like this
        // so we will create Synchronized block for only critical section

        Runnable normalSingletonTask = new NormalSingletonTask();
        Thread normalThread1 = new Thread(normalSingletonTask);
        Thread normalThread2 = new Thread(normalSingletonTask);

        normalThread1.start();
        normalThread2.start();

        //we will wait until both threads complete
        normalThread1.join();
        normalThread2.join();

        // we have ended up creating 2 object, where our main idea to create only 1 object
        // because t1 check condition context switched
        // t2 check condition context switched
        // the after continuation both created objects
        // to avoid this we make Synchronized

        // but instead of making complete function synchronised, make only critical block synchronized
        // so only one thread with lock can access

        SynchronizedSingletonTask synchronizedSingletonTask = new SynchronizedSingletonTask();
        Thread synchronizedThread1 = new Thread(synchronizedSingletonTask);
        Thread synchronizedThread2 = new Thread(synchronizedSingletonTask);

        synchronizedThread1.start();
        synchronizedThread2.start();


        synchronizedThread1.join();
        synchronizedThread2.join();

        // refer to this class SynchronizedSingleton

        // both we have only single object





    }


}
