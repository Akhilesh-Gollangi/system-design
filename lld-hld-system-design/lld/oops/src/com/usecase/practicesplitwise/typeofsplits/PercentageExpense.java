package com.usecase.practicesplitwise.typeofsplits;

import com.usecase.practicesplitwise.Expense;
import com.usecase.practicesplitwise.Split;
import com.usecase.practicesplitwise.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageExpense extends Expense {

    public PercentageExpense(String id, String description, User paidBy, double amount) {
        super(id, description, paidBy, amount);
    }

    @Override
    public List<Split> calculateSplit(List<User> users, List<Double> values) {
        List<Split> splitList = new ArrayList<>();
        double share = 0.0;
        for(int i=0;i<users.size();i++) {
            share = getAmount() * (values.get(i)/100);
            splitList.add(new Split(share, getPaidBy(), users.get(i)));
        }
        return splitList;
    }

}
