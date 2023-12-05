package MVP.Model.Abstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Client implements Comparable<Client>{

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id = 0;
    private String firstName;
    private String lastName;
    private String birthdayDate;
    private String phoneNumber;
    private int passwordHash;
    private List<Account> clientAccounts;

    protected Client(String firstName, String lastName, String birthdayDate, String phoneNumber, String password) {
        this.id = count.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phoneNumber = phoneNumber;
        this.passwordHash = (phoneNumber + password).hashCode();
    }

    public boolean openNewAccount(Account account){
        getClientAccounts().add(account);
        return true;
    }

    public boolean closeAccount(Account account){
        if(clientAccounts.isEmpty() || !clientAccounts.contains(account))
            throw new RuntimeException("There is no such account");
        return  clientAccounts.remove(account);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    /**
     * Class method. Creates, if not previously created, and returns a list of customer accounts
     * @return счета клиента
     */
    public List<Account> getClientAccounts() {
        if (clientAccounts == null)
            clientAccounts = new ArrayList<>();
        return clientAccounts;
    }

    /**
     * Returns a customer account object by its number
     * @param number  account number
     * @return account
     * @throws  RuntimeException in case of no account with such number
     */
    public Account getClientAccountByNumber(int number) {
        Account clientAccount = null;
        for (Account account: this.clientAccounts) {
            if(account.getNumber() == number)
                clientAccount = account;
        }
        if (clientAccount == null)
            throw new RuntimeException("There is no account with this number");
        return clientAccount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Client o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0)
            result = this.firstName.compareTo(o.firstName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(birthdayDate, client.birthdayDate) && Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthdayDate, phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passwordHash=" + passwordHash +
                ", clientAccounts=" + clientAccounts +
                '}';
    }
}
