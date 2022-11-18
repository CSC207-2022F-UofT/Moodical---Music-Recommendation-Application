package Processors;
import Entities.Account;
import Entities.Favourites;
import Entities.History;

import java.util.HashMap;

public class AccountCheckerProcessing extends Account {
    public AccountCheckerProcessing(String username, String password,
                                    History previous_songs, Favourites favourites) {
        super(username, password, previous_songs, favourites);
    }

    public void checkPassword(String password) {
        if (this.password.equals(password)) {
            System.out.println("Password Successful");
        } else {
            System.out.println("Password Incorrect. Please try again.");
        }
    }
}
