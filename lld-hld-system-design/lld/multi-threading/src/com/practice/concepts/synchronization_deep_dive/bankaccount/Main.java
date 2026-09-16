package com.practice.concepts.synchronization_deep_dive.bankaccount;

public class Main {

    public static void main(String[] args) throws InterruptedException {
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

        // without Synchronization, we face race condition
        NormalBankAccount normalBankAccount = new NormalBankAccount(1000.0);
        Runnable myNormalTask = new MyNormalTask(normalBankAccount, 700);

        Thread normalThread1 = new Thread(myNormalTask);
        Thread normalThread2 = new Thread(myNormalTask);

        normalThread1.start();
        normalThread2.start();

        // we will wait until both completes work then print balance
        normalThread1.join();
        normalThread2.join();

        System.out.println("Normal BankAccount Balance : " + normalBankAccount.getBalance());
        //we got -400

        //now we make it synchronied so thread which acquired lock will run and other thread has to
        // wait until lock is free

        SynchronizedBankAccount synchronizedBankAccount = new SynchronizedBankAccount(1000.0);
        Runnable mySynchronizedTask = new MySynchronizedTask(synchronizedBankAccount, 700);

        Thread syncThread1 = new Thread(mySynchronizedTask);
        Thread syncThread2 = new Thread(mySynchronizedTask);

        syncThread1.start();
        syncThread2.start();

        // we will wait until both completes work then print balance
        syncThread1.join();
        syncThread2.join();

        System.out.println("Synchronized BankAccount Balance : " + synchronizedBankAccount.getBalance());


        // Now we will do on different backaccount of synchronzied with different objects
        // so both threads have their corresponding lock they can access synchronzied block at once
        // no need to wait for other thread to release lock

        SynchronizedBankAccount synchronizedBankAccount1 = new SynchronizedBankAccount(1000.0);
        SynchronizedBankAccount synchronizedBankAccount2 = new SynchronizedBankAccount(1000.0);
        Runnable mySynchronizedTask1 = new MySynchronizedTask(synchronizedBankAccount1, 700);
        Runnable mySynchronizedTask2 = new MySynchronizedTask(synchronizedBankAccount2, 700);

        Thread t1 = new Thread(mySynchronizedTask1);
        Thread t2 = new Thread(mySynchronizedTask2);

        t1.start();
        t2.start();

        // we will wait until both completes work then print balance
        t1.join();
        t2.join();

        System.out.println("Synchronized BankAccount Balance : " + synchronizedBankAccount1.getBalance());
        System.out.println("Synchronized BankAccount Balance : " + synchronizedBankAccount2.getBalance());



    }


}
