package MVP.Model.Abstract;

import java.util.HashMap;

public abstract class Transaction {
    /**
     Abstract class method. Responsible for transferring funds between accounts
     * @param funds transaction amount
     * @param senderAccount sender's account number
     * @param receiverAccount recipient's account number
     * @param clients list of clients
     * @return true in case of success
     */
    public abstract boolean sendMoneyToOtherClient(double funds, int senderAccount, int receiverAccount, HashMap<String, Client> clients);
}
