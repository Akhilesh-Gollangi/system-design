package com.usecase.practicesplitwise.typeofsplits;

import com.usecase.practicesplitwise.Expense;
import com.usecase.practicesplitwise.Split;
import com.usecase.practicesplitwise.User;

import java.util.ArrayList;
import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(String id, String description, User paidBy, double amount) {
        super(id, description, paidBy, amount);
    }

    @Override
    public List<Split> calculateSplit(List<User> users, List<Double> values) {
        List<Split> splitList = new ArrayList<>();
        double share = getAmount()/users.size();
        for (User user:users) {
            splitList.add(new Split(share,getPaidBy(),user));
        }
        return splitList;
    }
}
