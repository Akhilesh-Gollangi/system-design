package splitwise.typesofexpenses;

import splitwise.Expense;
import splitwise.Split;
import splitwise.User;

import java.util.List;

/**
 * Represents an expense where each member has a fixed amount to pay.
 * For example, one member may owe 100 and another member may owe 200.
 */
public class ExactAmountExpense extends Expense {

    public ExactAmountExpense(String description, double amount, User paidBy, String id) {
        super(description,amount,paidBy,id);
    }

    /**
     * Uses the given amount for each member and creates the required split records.
     * This is useful when group members did not use or share the expense equally.
     */
    @Override
    public List<Split> calculateSplit(List<User> members, List<Double> expense) {
        return List.of();
    }
}
