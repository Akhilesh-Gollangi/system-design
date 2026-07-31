package splitwise;

import java.util.List;

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

    // add member
    public void addMember(String id, String name) {
        members.add(new User(id,name));
    }

    // Add Expense
    public void addExpense(Expense expense, List<User> users, List<Double> amount) {
        List<Split> splitList = expense.calculateSplit(users, amount);
        splits.addAll(splitList);
        expenses.add(expense);
    }


    //get balance for a user
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
