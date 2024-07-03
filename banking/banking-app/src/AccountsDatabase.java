import Components.Account;
import Components.AccountType;
import Components.IDStore;
import Components.Person;

import java.util.ArrayList;

public class AccountsDatabase {
    private ArrayList<Account> accountList;
    private IDStore ids;

    public AccountsDatabase(){
        this.accountList = new ArrayList<>();
        this.ids = new IDStore();
    }

    public Account createAccount(Person holder, AccountType type, double initialBalance){
        int newAccountId = ids.generateId();
        Account newAccount = new Account(holder, type, initialBalance, newAccountId);
        accountList.add(newAccount);
        return newAccount;
    }


}
