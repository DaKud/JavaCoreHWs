package MVP.Model.AccountExceptions;

public class IncorrectAmountTransactionException extends IllegalArgumentException {
    private double amount;
    public IncorrectAmountTransactionException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
