package com.usecase.practicesplitwise;

public class Split {

    private double amount;

    private User creditor;

    private User debitor;

    public double getAmount() {
        return amount;
    }

    public User getCreditor() {
        return creditor;
    }

    public User getDebitor() {
        return debitor;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreditor(User creditor) {
        this.creditor = creditor;
    }

    public void setDebitor(User debitor) {
        this.debitor = debitor;
    }

    public Split(double amount, User creditor, User debitor) {
        this.amount = amount;
        this.creditor = creditor;
        this.debitor = debitor;
    }

    @Override
    public String toString() {
        return "Split{" +
                "amount=" + amount +
                ", creditor=" + creditor +
                ", debitor=" + debitor +
                '}';
    }
}
