package splitwise;

/**
 * Represents one payment relationship created from an expense.
 * It records how much the debitor needs to pay the creditor.
 */
public class Split {

    private double amount;

    private User creditor;

    private User Debitor;

    public Split(double amount, User creditor, User debitor) {
        this.amount = amount;
        this.creditor = creditor;
        Debitor = debitor;
    }

    public double getAmount() {
        return amount;
    }

    public User getCreditor() {
        return creditor;
    }

    public User getDebitor() {
        return Debitor;
    }
}
