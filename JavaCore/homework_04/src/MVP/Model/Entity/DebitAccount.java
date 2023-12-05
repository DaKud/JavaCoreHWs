package MVP.Model.Entity;

import MVP.Model.AccountExceptions.InitialDepositException;
import MVP.Model.AccountExceptions.InsufficientFundsException;
import MVP.Model.AccountExceptions.NegativeDepositException;
import MVP.Model.Abstract.Account;

public class DebitAccount extends Account {

    private DebitAccount(double balance) {
        super(balance);
    }

    /**
     * Static class method. Creates a new debit account
     * @param balance initial account balance
     * @return the newly created account
     * @throws InitialDepositException if an attempt is made to create an account with a negative initial balance
     */
    public static DebitAccount createNewDebitAccount(double balance) {
        if (balance < 0)
            throw new InitialDepositException("Unable to create an account with a negative balance", balance);
        return new DebitAccount(balance);
    }

    /**
     * Public class method. Responsible for depositing funds into the account
     * @param cashAmount the amount of the deposited amount
     * @return true if the deposit was successful
     * @throws NegativeDepositException if the deposit amount is negative
     */
    @Override
    public boolean addFunds(double cashAmount) {
        if (cashAmount < 0)
            throw new NegativeDepositException("The deposit amount cannot be negative", cashAmount);
        super.setBalance(super.getBalance() + cashAmount);
        return true;
    }

    /**
     * Public class method. Responsible for withdrawing funds from the account
     * @param cashAmount size of the withdrawn amount
     * @return true on success
     * @throws NegativeDepositException if the requested funds are negative
     * @throws InsufficientFundsException in case of insufficient funds in the account
     */
    @Override
    public boolean withdrawFunds(double cashAmount) {
        if (cashAmount < 0)
            throw new NegativeDepositException("The charged amount  cannot be negative", cashAmount);
        if (cashAmount > super.getBalance())
            throw new InsufficientFundsException("Insufficient funds", super.getBalance(), cashAmount);
        super.setBalance(super.getBalance() - cashAmount);
        return true;
    }
}
