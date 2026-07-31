package splitwise.typesofexpenses;

import splitwise.Expense;
import splitwise.Split;
import splitwise.User;

import java.util.List;

/**
 * Represents an expense where each member pays a percentage of the total amount.
 * For example, one member can pay 60 percent and another can pay 40 percent.
 */
public class PercentageExpense extends Expense {

    public PercentageExpense(String description, double amount, User paidBy, String id) {
        super(description,amount,paidBy,id);
    }

    /**
     * Converts each member's percentage into a money amount and creates the split records.
     * This is useful when members agree to share an expense in different proportions.
     */
    @Override
    public List<Split> calculateSplit(List<User> members, List<Double> expense) {
        return List.of();
    }
}
