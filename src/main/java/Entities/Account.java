package Entities;

import java.util.HashMap;
import java.util.Objects;


public class Account {
    String username = "";
    String password = "";
    HashMap<String, String> AllUsers = new HashMap<String, String>();
    // History userHistory = new History();
    // Favourites userFavourites = new Favourites();

    public Account(String username, String password) {
        // Want to add (History userHistory, Favourites userFavourites) to parameters
        this.username = username;
        this.password = password;
        // this.userHistory = userHistory;
        // this.userFavourites = userFavourites;
    }

    public void createAccount(String username, String password) {
        AllUsers.put(username, password);
    }

    public boolean checkUserExists(String username, String password) {
        // If user exists, check the password
        if (AllUsers.containsKey(username)) {
            checkPassword(AllUsers.get(username));
        // If user does not exist, create an account for the user
        } else {
            createAccount(username, password);
            return true;
        }
        return false;
    }

    public void checkPassword(String password) {
        if (this.password.equals(password)) {
            System.out.println("Password Successful");
        } else {
            System.out.println("Password Incorrect. Please try again.");
        }
    }

    public void changeUsername(String newUsername) {
        AllUsers.remove(username);
        this.username = newUsername;
        AllUsers.put(username, password);
    }

    public void changePassword(String newPassword) {
        AllUsers.put(username, newPassword);
    }
}
