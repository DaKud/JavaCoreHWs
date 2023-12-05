package MVP.Model.AccountExceptions;

public class InitialDepositException extends IllegalArgumentException{
    private double balance;

    public double getBalance(){
        return  balance;
    }

    /**
     * Exception class thrown when trying to create an account with a negative opening balance.
     * @param message Message printed when attempting to create an account with a negative opening balance.
     * @param balance the passed balance value.
     */
    public InitialDepositException(String message, double balance){
        super(message);
        this.balance = balance;
    }
    
}
