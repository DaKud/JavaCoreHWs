package MVP.Model.AccountExceptions;

public class InsufficientFundsException extends RuntimeException{

    private double balance;

    private double requestedAmount;

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Exception class thrown when requesting funds in excess of the available amount
     * @param message message to display
     * @param balance current balance
     * @param requestedAmount requested funds
     */
    public InsufficientFundsException(String message, double balance, double requestedAmount){
        super(message);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }
}
