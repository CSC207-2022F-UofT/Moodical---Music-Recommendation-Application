package Processors;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Processors.UserRegisterProcessing;

import java.util.HashMap;

public class AccountCheckerProcessing {
    HashMap<String, String> AllUsers = new HashMap<String, String>();
    public AccountCheckerProcessing(Account account){
        AllUsers = new HashMap<String, String>();
    }

    public void MapAllAccounts(String username, String password) {
        AllUsers.put(username, password);
    }

    public boolean checkUserExists(String username) {
        return AllUsers.containsKey(username);
    }

    public boolean createNewAccount(Account account) {
        if (!(checkUserExists(account.username))) {
            UserRegisterProcessing.createAccount(account);
            MapAllAccounts(account.username, account.password);
            return true;
        }
        return false;
    }

    public void checkPassword(Account account, String password) {
        if (account.password.equals(password)) {
            System.out.println("Password Successful");
        } else {
            System.out.println("Password Incorrect. Please try again.");
        }
}

}

