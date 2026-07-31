package splitwise.typesofexpenses;

import splitwise.Expense;
import splitwise.Split;
import splitwise.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an expense where each member has a fixed amount to pay.
 * For example, one member may owe 100 and another member may owe 200.
 */
public class ExactAmountExpense extends Expense {

    public ExactAmountExpense(String description, double amount, User paidBy, String id) {
        super(description, amount, paidBy, id);
    }

    /**
     * Uses the given amount for each member and creates the required split records.
     * This is useful when group members did not use or share the expense equally.
     * user who paid the bill will not be in participants
     */
    @Override
    public List<Split> calculateSplit(List<User> participants, List<Double> values) {
        double totalAmount=0;
        for(double val:values) {
            totalAmount += val;
        }
        if(totalAmount-getAmount()>0.01) {
            throw new IllegalArgumentException("totalAmount must match with amount");
        }

        List<Split> splitList = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            Split split = new Split(values.get(i), getPaidBy(), participants.get(i));
            splitList.add(split);
        }
        return splitList;
    }
}
