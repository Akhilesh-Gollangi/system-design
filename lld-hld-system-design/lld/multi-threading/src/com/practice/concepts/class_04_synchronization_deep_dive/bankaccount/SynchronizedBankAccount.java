package com.practice.concepts.class_04_synchronization_deep_dive.bankaccount;

public class SynchronizedBankAccount {
    private double balance;

    public SynchronizedBankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // from link 19 to end which is the critical section
    // if amount<=0 is not need as we are checking amount>balance
    // as we are facing race condition we make synchronized

    // here we are making entire function synchronized, if we do like this we end up in synchronized code
//    public synchronized void withdraw(double amount) {
//        if(balance<=0) {
//            return;
//        }
//        if(amount>balance) {
//            return;
//        }
//
//        //Here we are using sleep, so t1 comes first here and read it context switched
//        // so t2 also read conditon comes here and context switched
//        // we are forcing threads to context switch using click
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            System.out.println("Error");
//        }
//        balance -= amount;
//    }


    //Instead of entire function Synchronized, we will do particular critical section synchronized
    // from check amount>balance it critical block
    // we make it synchronized
    public void withdraw(double amount) {
        if (balance <= 0) {
            return;
        }

        // this is the current object, we require this as it's lock is based on the object
        // Writing Thread safe code is good practice
        synchronized (this) {
            if (amount > balance) {
                return;
            }

            //Here we are using sleep, so t1 comes first here and read it context switched
            // so t2 also read conditon comes here and context switched
            // we are forcing threads to context switch using click
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            balance -= amount;
        }
    }
}

