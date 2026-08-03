package com.usecase.splitwise;

/**
 * Represents one payment relationship created from an expense.
 * It records how much the debitor needs to pay the creditor.
 */
public class Split {

    private double amount;

    private User creditor;

    private User debitor;

    public Split(double amount, User creditor, User debitor) {
        this.amount = amount;
        this.creditor = creditor;
        this.debitor = debitor;
    }

    public double getAmount() {
        return amount;
    }

    public User getCreditor() {
        return creditor;
    }

    public User getDebitor() {
        return debitor;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"amount\": " + amount + ",\n" +
                "  \"creditor\": \"" + creditor + "\",\n" +
                "  \"debitor\": \"" + debitor + "\"\n" +
                "}";
    }
}
