package splitwise.typesofexpenses;

import splitwise.Expense;
import splitwise.Split;
import splitwise.User;

import java.util.List;

public class EqualsExpense extends Expense {

    public EqualsExpense(String description, double amount, User paidBy, String id) {
        super(description,amount,paidBy,id);
    }

    @Override
    public List<Split> calculateSplit(List<User> members, List<Double> expense) {
        return List.of();
    }
}
