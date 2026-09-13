package com.vending_machine.practice.intialrequirement.trasaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<Transaction> transactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }
}
