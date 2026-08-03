package com.usecase.practicesplitwise;

import java.util.List;

public abstract class Expense {

    private String id;

    private String description;

    private User paidBy;

    private double amount;

    public abstract List<Split> calculateSplit(List<User> users, List<Double> values);

    public Expense(String id, String description, User paidBy, double amount) {
        this.id = id;
        this.description = description;
        this.paidBy = paidBy;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", paidBy=" + paidBy +
                ", amount=" + amount +
                '}';
    }
}
