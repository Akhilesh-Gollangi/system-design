package splitwise.typesofexpenses;

import splitwise.Expense;
import splitwise.Split;
import splitwise.User;

import java.util.ArrayList;
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
     * user who paid the bill will not be in participants
     */
    @Override
    public List<Split> calculateSplit(List<User> participants, List<Double> values) {

        double totalPercent = 0;
        for(double value:values) {
            totalPercent +=value;
        }

        if(Math.abs(totalPercent-100)>0.01) {
            throw new IllegalArgumentException("Percentages are not equal to 100");
        }

        List<Split> splitList = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            Split split = new Split(getAmount()*(values.get(i)/100), getPaidBy(), participants.get(i));
            splitList.add(split);
        }
        return splitList;
    }
}
