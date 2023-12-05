package MVP.Model.AccountExceptions;

import MVP.Model.Abstract.Client;

import java.util.HashMap;

public class NullPointerClientHashMapException extends NullPointerException {

    private HashMap<String, Client> clients;

    public NullPointerClientHashMapException(String message, HashMap<String, Client> clients) {
        super(message);
        this.clients = clients;
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }
}
