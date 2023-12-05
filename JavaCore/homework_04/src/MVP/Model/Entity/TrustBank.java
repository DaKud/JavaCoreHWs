package MVP.Model.Entity;

import MVP.Model.Abstract.Bank;
import MVP.Model.Abstract.Client;
import MVP.Model.Abstract.Transaction;

public class TrustBank extends Bank {

    public TrustBank(String title) {
        super(title, new BankTransaction());
    }

    /**
     * Adds a new client to the list of bank clients
     * @param client the requested client
     * @return returns true if the new client was successfully added
     * @throws RuntimeException if the list is empty
     */
    @Override
    public boolean addClient(Client client) {
        if(this.getListClients() == null)
            throw new RuntimeException("The client list is empty");
        this.getListClients().put(client.getPhoneNumber(), client);
        return true;
    }

    /**
     * Finds a client in the list of bank clients by phone number
     * @param phoneNumber
     * @return the requested client
     * @throws RuntimeException if there is no client with the specified phone number
     */
    @Override
    public Client findClientByPhoneNumber(String phoneNumber) {
        Client client = null;
        if(!this.getListClients().containsKey(phoneNumber))
            throw new RuntimeException("There is no client with such number");
        client = getListClients().get(phoneNumber);
        return client;
    }

    /**
     * Returns the client by his id
     * @param id number of the requested client
     * @return the requested client
     * @throws RuntimeException if there is no client with the specified id
     */
    @Override
    public Client findClientByid(int id) {
        Client client = null;
        for (Client found: this.getListClients().values()) {
            if(found.getId() == id)
                client = found;
        }
        if(client == null)
            throw new RuntimeException("There is no client with this id");
        return client;
    }
}
