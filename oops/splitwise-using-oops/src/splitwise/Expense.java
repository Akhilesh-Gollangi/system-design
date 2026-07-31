package splitwise;

import java.util.List;

public abstract class Expense {

    private String description;

    private double amount;

    private User paidBy;

    private String id;

    public Expense(String description, double amount, User paidBy, String id) {
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.id = id;
    }

    //we need to have abstract method to calculate the split
    public abstract List<Split> calculateSplit(List<User> members, List<Double> expense);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
