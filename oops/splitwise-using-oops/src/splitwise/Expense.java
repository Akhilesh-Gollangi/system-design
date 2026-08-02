package splitwise;

import java.util.List;

/**
 *
 */
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

    /**
     * Once User want to split, he can split in the type he wants (EQUALS, PERCENTAGE, EXACT amount)
     * Instead of having 3 method for each type, we have only method which extended by classes which needed
     * This is helps because new Type came in future it will not touch this class
     * they can easily extend this class and have their implemenetations
     * At runtime polymorphism they can use the object they want
     */
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
