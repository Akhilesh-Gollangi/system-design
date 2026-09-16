package com.practice.concepts.class_04_synchronization_deep_dive.bankaccount;

public class MySynchronizedTask implements Runnable{

    private SynchronizedBankAccount synchronizedBankAccount;
    private double amount;

    public MySynchronizedTask(SynchronizedBankAccount synchronizedBankAccount, double amount) {
        this.synchronizedBankAccount = synchronizedBankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronizedBankAccount.withdraw(amount);
    }
}
