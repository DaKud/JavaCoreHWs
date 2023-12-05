package MVP;

import MVP.Model.Abstract.Account;
import MVP.Model.Abstract.Client;
import MVP.Model.Entity.CreditAccount;
import MVP.Model.Entity.DebitAccount;

import java.util.HashMap;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    /**
     * The method displays the main menu in the console. Returns the selected item.
     * @return Selected menu item
     */
    public int printMainMenu(){
        System.out.println("1. Get a list of all bank clients.\n" +
                "2. Get a list of client accounts.\n" +
                "3. Open a new account.\n" +
                "4. Deposit funds into the account.\n" +
                "5. Withdraw funds from the account.\n" +
                "6. Transfer between accounts.\n");
        System.out.print("Select a menu item: ");
        return scanner.nextInt();

    }

    /**
     * Method prints customer invoices
     * @param client object whose accounts will be displayed in the console
     */
    public void printClientAccounts(Client client){
        for (Account account: client.getClientAccounts()) {
            System.out.println(account.toString());
        }
    }

    /**
     * Method prints a list of all bank clients
     * @param clients list of bank clients
     */
    public void printBankClients (HashMap<String, Client> clients) {
        for (Client client: clients.values()) {
            System.out.println(client.toString());
        }
    }

    /**
     * Method returning the selected bank client id
     * @param clients list of bank clients
     * @return id
     */
    public int choiceClient(HashMap<String, Client> clients){
        printBankClients(clients);
        System.out.print("Select client id: ");
        return scanner.nextInt();
    }

    /**
     * Method returning the selected client account number
     * @param client client
     * @return the selected account number
     */
    public int choiceClientAccountNumber(Client client){
        printClientAccounts(client);
        System.out.print("Select an account: ");
        return scanner.nextInt();
    }

    public boolean exit() {
        System.out.print("Would you like to finish? y/n");
        return scanner.next().equalsIgnoreCase("y")?  true : false;
    }

    /**
     * The method returns the newly created account (Credit or Debit)
     * @return the newly created account
     */
    public Account choiceAccountType(){
        System.out.println("What type of account do you want to open?? Debit/Credit");
        Account newAccout = null;
        if (scanner.next().equalsIgnoreCase("debit"))
            newAccout = DebitAccount.createNewDebitAccount(initDebitBalance());
        if (scanner.next().equalsIgnoreCase("сredit"))
            newAccout = CreditAccount.createNewCreditAccount(initCreditBalance());
        return newAccout;
    }

    /**
     * Method that returns the specified size of the initial balance when creating a new account
     * @return initial deposit size
     */
    private double initDebitBalance(){
        System.out.print("What initial balance do you want to set: ");
        double initDebitBalance = scanner.nextDouble();
        return  initDebitBalance;
    }

    /**
     * Method that returns the specified amount of the credit limit for an account when it is created
     * @return credit limit size
     */
    private double initCreditBalance(){
        System.out.print("Specify the credit limit amount: ");
        return scanner.nextDouble();
    }

    /**
     * Method returning the amount of account replenishment
     * @return replenishment value
     */
    public double increaseAccountBalance(){
        System.out.print("Enter the amount to top up your account:");
        return scanner.nextDouble();
    }

    /**
     * Method returning the amount of funds withdrawn
     * @return the amount of funds requested
     */
    public double deincreaseAccountBalance(){
        System.out.print("Enter the amount to withdraw from the account: ");
        return scanner.nextDouble();
    }

    /**
     * Method returning the amount of funds transferred * @return the amount of the requested funds
     */
    public double amountTransaction(){
        System.out.print("Enter transfer size: ");
        return scanner.nextDouble();
    }

}
