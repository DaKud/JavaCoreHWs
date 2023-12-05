package MVP.Model.Abstract;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Account {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int number=1;
    private double balance;

    protected Account(double balance) {
        this.number = count.incrementAndGet();
        this.balance = balance;
    }

    /**
     * Returns the account number of an object
     * @return номер счета
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the current account balance
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the account balance to the specified value
     * @param balance требуемое значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Abstract method of depositing funds into an account
     * @param cashAmount размер вносимой суммы
     * @return true в случае успешного исхода
     */
    public abstract boolean addFunds(double cashAmount);

    /**
     * Abstract method of withdrawing funds from an account
     * @param cashAmount amount of funds withdrawn
     * @return true in case of a successful outcome
     */
    public abstract boolean withdrawFunds(double cashAmount);

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
