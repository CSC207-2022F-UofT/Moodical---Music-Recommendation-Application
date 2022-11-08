package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class Account {
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

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
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
