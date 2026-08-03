package com.usecase.practicesplitwise;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String id;

    private String name;

    private List<User> users;

    private List<Expense> expenses;

    private List<Split> splitList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.splitList = new ArrayList<>();
    }

    //add user
    public void addUser(User user) {
        users.add(user);
    }

    //calculate splits
    public void addExpense(Expense expense, List<User> users, List<Double> values) {
        // runtime polymorphism
        List<Split> splits = expense.calculateSplit(users, values);
        splitList.addAll(splits);
        expenses.add(expense);
    }

    // calculate balance of a user
    public double getUserBalance(User user) {
        double balance = 0.0;
        for(Split split:splitList) {
            if(split.getCreditor().getId().equals(user.getId())) {
                balance += split.getAmount();
            } else if (split.getDebitor().getId().equals(user.getId())) {
                balance -= split.getAmount();
            }
        }
        return balance;
    }


    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", expenses=" + expenses +
                ", splitList=" + splitList +
                '}';
    }
}
