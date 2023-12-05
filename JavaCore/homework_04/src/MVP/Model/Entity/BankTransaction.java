package MVP.Model.Entity;
import MVP.Model.Abstract.Account;
import MVP.Model.Abstract.Client;
import MVP.Model.Abstract.Transaction;
import MVP.Model.AccountExceptions.IncorrectAccountTransactionException;
import MVP.Model.AccountExceptions.IncorrectAmountTransactionException;
import MVP.Model.AccountExceptions.NullPointerClientHashMapException;

import java.util.HashMap;

public class BankTransaction extends Transaction {

    /**
     * Public class method. Responsible for transferring funds between accounts
     * @param funds size of money transfer
     * @param senderAccount Debit account number
     * @param receiverAccount recipient's account number
     * @param clients list of clients
     * @return true on success
     * @throws IncorrectAmountTransactionException if an incorrect value is specified
     * @throws IncorrectAccountTransactionException if there is an error in the account number
     * @throws NullPointerClientHashMapException if there is no recipient list
     */
    @Override
    public boolean sendMoneyToOtherClient(double funds, int senderAccount, int receiverAccount, HashMap<String, Client> clients) {
        if(funds == 0) throw new IncorrectAmountTransactionException("Enter the valid amount for transfer", funds);
        if(senderAccount == 0) throw new IncorrectAccountTransactionException("Enter the account number for debiting funds", senderAccount);
        if(receiverAccount == 0) throw new IncorrectAccountTransactionException("Enter the recipient's account number ", receiverAccount);
        if(clients == null) throw new NullPointerClientHashMapException("Mailing list not available", clients);
        Account sender = null;
        Account receiver = null;
        for (Client client: clients.values()) {
            for (Account account: client.getClientAccounts()) {
                if(account.getNumber() == senderAccount)
                    sender = account;
                if(account.getNumber() == receiverAccount)
                    receiver = account;
            }
        }
        if (sender == null || receiver == null)
            throw new RuntimeException("Check details");
        sender.withdrawFunds(funds);
        receiver.addFunds(funds);
        return true;
    }
}
