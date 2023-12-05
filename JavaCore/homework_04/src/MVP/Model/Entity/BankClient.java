package MVP.Model.Entity;

import MVP.Model.Abstract.Client;

public class BankClient extends Client {

    private BankClient(String firstName, String lastName, String birthdayDate, String phoneNumber, String password) {
        super(firstName, lastName, birthdayDate, phoneNumber, password);
    }

    /**
     * Static class method. Responsible for creating a bank client object
     * @param firstName Name
     * @param lastName Last name
     * @param birthdayDate date of birth in DD/MM/YYYY format
     * @param phoneNumber phone number
     * @param password password
     * @return the newly created class object
     * @throws RuntimeException in case of invalid initial data
     */
    public static BankClient createNewClient(String firstName, String lastName, String birthdayDate, String phoneNumber, String password) {
        if (firstName == null) throw new RuntimeException("Enter a valid name");
        if (lastName == null) throw new RuntimeException("Enter a valid Lastname");
        if (birthdayDate == null) throw new RuntimeException("Enter the correct date of birth");
        if (phoneNumber == null) throw new RuntimeException("Enter a valid phone number");
        if (password == null) throw new RuntimeException("Your password does not comply with the security policy");
        return new BankClient(firstName, lastName, birthdayDate, phoneNumber, password);
    }

}
