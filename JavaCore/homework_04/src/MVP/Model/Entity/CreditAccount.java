package MVP.Model.Entity;

import MVP.Model.AccountExceptions.InitialDepositException;
import MVP.Model.AccountExceptions.InsufficientFundsException;
import MVP.Model.AccountExceptions.NegativeDepositException;
import MVP.Model.Abstract.Account;

public class CreditAccount extends Account {
    private double limit;
    private double creditDebt;

    private CreditAccount(double balance, double limit) {
        super(balance);
        this.limit = limit;
        this.creditDebt = 0;
    }

    private CreditAccount(double limit) {
        this(limit, limit);
    }

    /**
     * Static class method. Responsible for creating an object with the initial specified parameters
     * @param limit size of the account credit limit
     * @return a class object
     * @throws InitialDepositException if an attempt is made to create an account with a negative initial account limit
     */
    public static CreditAccount createNewCreditAccount(double limit) {
        if (limit < 0)
            throw new InitialDepositException("Cannot create a credit account with a negative limit", limit);
        return new CreditAccount(limit);
    }

    public double getLimit() {
        return limit;
    }

    public double getCreditDebt() {
        return creditDebt;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setCreditDebt(double creditDebt) {
        this.creditDebt = creditDebt;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
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
            throw new NegativeDepositException("The amount of the deposit made to the credit account cannot be negative", cashAmount);
        super.setBalance(super.getBalance() + cashAmount);
        this.setCreditDebt(this.getCreditDebt() - cashAmount);
        return true;
    }

    /**
     * Public class method. Responsible for withdrawing funds from the account
     * @param cashAmount size of the withdrawn amount
     * @return true on success
     * @throws NegativeDepositException if the requested funds are negative
     * @throws InsufficientFundsException if there is insufficient funds in the account or if the limit has been reached.
     */
    @Override
    public boolean withdrawFunds(double cashAmount) {
        if (cashAmount < 0)
            throw new NegativeDepositException("The charged amount  cannot be negative", cashAmount);
        if (cashAmount > this.getBalance())
            throw new InsufficientFundsException("Insufficient funds", super.getBalance(), cashAmount);
        if ( this.creditDebt == this.limit)
            throw  new InsufficientFundsException("Funds limit has been reached", this.getLimit() - this.getCreditDebt(), cashAmount);
        super.setBalance(super.getBalance() - cashAmount);
        this.setCreditDebt(this.getCreditDebt() + cashAmount);
        return true;
    }
}
