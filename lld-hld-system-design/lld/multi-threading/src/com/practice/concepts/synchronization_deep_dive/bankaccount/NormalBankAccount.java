package com.practice.concepts.synchronization_deep_dive.bankaccount;

public class NormalBankAccount {
    private double balance;

    public NormalBankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // from link 19 to end which is the critical section
    // if amount<=0 is not need as we are checking amount>balance
    // as we are facing race condition we make synchronized
    public void withdraw(double amount) {
        if(balance<=0) {
            return;
        }
        if(amount>balance) {
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

