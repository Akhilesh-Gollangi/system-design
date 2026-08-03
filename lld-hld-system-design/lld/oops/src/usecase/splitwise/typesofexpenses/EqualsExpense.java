package usecase.splitwise.typesofexpenses;

import usecase.splitwise.Expense;
import usecase.splitwise.Split;
import usecase.splitwise.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an expense where every member pays the same share.
 * For example, a 300 bill for three members gives each member a 100 share.
 */
public class EqualsExpense extends Expense {

    public EqualsExpense(String description, double amount, User paidBy, String id) {
        super(description, amount, paidBy, id);
    }

    /**
     * Calculates equal shares for all members and creates the required split records.
     * These records tell each member how much to pay the person who paid the bill.
     * user who paid the bill will not be in participants
     */
    @Override
    public List<Split> calculateSplit(List<User> participants, List<Double> values) {
        double share = getAmount() / participants.size();
        List<Split> splitList = new ArrayList<>();
        for (User user : participants) {
            splitList.add(new Split(share, getPaidBy(), user));
        }
        return splitList;
    }
}
