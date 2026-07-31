package splitwise;

import java.util.List;

/**
 * Represents a group of users who share expenses together.
 * It keeps the group's members, expenses, and split records in one place.
 */
public class Group {

    private String id;

    private String name;

    private List<User> members;

    private List<Expense> expenses;

    private List<Split> splits;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Expense> getExpense() {
        return expenses;
    }

    public void setExpense(List<Expense> expense) {
        this.expenses = expense;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    /**
     * Adds a new user to this group.
     * The added user can take part in future group expenses.
     */
    public void addMember(String id, String name) {
        members.add(new User(id,name));
    }

    /**
     * Based on the Type of the Expense we get, we call that particular object method
     * The decision to call which method is decided at runtime
     * In future we get any new type still we donot get any changes here
     * because just based on the type of the object, it will call the specific method
     *  addExpense : as soon as I add an expense splits should be generated
     */
    public void addExpense(Expense expense, List<User> users, List<Double> amount) {
        List<Split> splitList = expense.calculateSplit(users, amount);
        splits.addAll(splitList);
        expenses.add(expense);
    }


    /**
     * Calculates the final balance of one user from all split records.
     * A positive balance means the user should receive money; a negative balance means the user owes money.
     */
    public double getUserBalance(String userId, List<Split> splits) {
        double balance = 0;
        for(Split split : splits) {
            if(split.getCreditor().getId().equals(userId)) {
                balance += split.getAmount();
            } else if (split.getDebitor().getId().equals(userId))  {
                balance -= split.getAmount();

            }
        }
        return balance;
    }
}
