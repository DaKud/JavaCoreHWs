package MVP.Model.AccountExceptions;

public class NegativeDepositException extends IllegalArgumentException{
    private double cash;

    public double getCash(){
        return cash;
    }

    /**
     * Exception class thrown when trying to pass a negative amount to a method.
     * @param message Message displayed when trying to pass a negative value to the method for deposited funds
     * @param cash transmitted value of deposited funds
     */
    public NegativeDepositException(String message, double cash){
        super(message);
        this.cash = cash;
    }
}
