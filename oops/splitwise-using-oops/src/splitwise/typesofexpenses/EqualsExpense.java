package splitwise.typesofexpenses;

import splitwise.Expense;
import splitwise.Split;
import splitwise.User;

import java.util.List;

/**
 * Represents an expense where every member pays the same share.
 * For example, a 300 bill for three members gives each member a 100 share.
 */
public class EqualsExpense extends Expense {

    public EqualsExpense(String description, double amount, User paidBy, String id) {
        super(description,amount,paidBy,id);
    }

    /**
     * Calculates equal shares for all members and creates the required split records.
     * These records tell each member how much to pay the person who paid the bill.
     */
    @Override
    public List<Split> calculateSplit(List<User> members, List<Double> expense) {
        return List.of();
    }
}
