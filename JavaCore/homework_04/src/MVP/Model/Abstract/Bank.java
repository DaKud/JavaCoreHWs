package MVP.Model.Abstract;

import java.util.HashMap;

public abstract class Bank {
    private String title;

    private Transaction transaction;
    private HashMap<String, Client> clients;

    protected Bank(String title, Transaction transaction) {
        this.title = title;
        this.transaction = transaction;
        clients = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public HashMap<String, Client> getListClients() {
        return clients;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Abstract method for adding a new client
     * @param client new client
     * @return true in case of successful addition of a new client
     */
    public abstract boolean addClient(Client client);

    /**
     * Abstract method of searching for a client by his mobile phone number
     * @param phoneNumber phone number
     * @return desired client
     */
    public abstract Client findClientByPhoneNumber(String phoneNumber);

    /**
     * Abstract method of searching for a client by his id
     * @param id client's number
     * @return desired client
     */
    public abstract Client findClientByid(int id);
}
