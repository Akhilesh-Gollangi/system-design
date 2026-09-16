package com.practice.concepts.class_04_synchronization_deep_dive.bankaccount;

public class MyNormalTask implements Runnable{

    private NormalBankAccount normalBankAccount;
    private double amount;

    public MyNormalTask(NormalBankAccount normalBankAccount, double amount) {
        this.normalBankAccount = normalBankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        normalBankAccount.withdraw(amount);
    }
}
