package com.usecase.practicesplitwise.typeofsplits;

import com.usecase.practicesplitwise.Expense;
import com.usecase.practicesplitwise.Split;
import com.usecase.practicesplitwise.User;

import java.util.ArrayList;
import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(String id, String description, User paidBy, double amount) {
        super(id, description, paidBy, amount);
    }

    @Override
    public List<Split> calculateSplit(List<User> users, List<Double> values) {
        List<Split> splitList = new ArrayList<>();
        for(int i=0;i<users.size();i++) {
            splitList.add(new Split(values.get(i), getPaidBy(), users.get(i)));
        }
        return splitList;
    }
}
