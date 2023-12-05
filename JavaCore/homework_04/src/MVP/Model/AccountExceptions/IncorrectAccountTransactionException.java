package MVP.Model.AccountExceptions;

public class IncorrectAccountTransactionException extends IllegalArgumentException {
    private int accountNumber;

    public IncorrectAccountTransactionException(String message, int accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
