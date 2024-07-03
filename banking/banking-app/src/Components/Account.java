package Components;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private Person accountHolder;
    private AccountType accountType;
    private double balance;
    private int accountID;

    public Account(Person person, AccountType type, double initialBalance, int accountID){
        this.accountHolder = person;
        this.accountType = type;
        this.balance = 0;
        this.accountID = accountID;
    }
}
