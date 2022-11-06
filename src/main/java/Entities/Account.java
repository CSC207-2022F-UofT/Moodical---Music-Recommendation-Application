package main.java.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class Account extends History {
    public String username = "";
    public String password = "";
    public HashMap<String, String> AllUsers = new HashMap<String, String>();
    public History userHistory;
    public Favourites userFavourites;

    public Account(String username, String password, History previous_songs, Favourites favourites) {
        super();
        this.username = username;
        this.password = password;
        this.userHistory = previous_songs;
        this.userFavourites = favourites;
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
