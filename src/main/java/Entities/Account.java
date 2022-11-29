package Entities;

import static java.nio.file.Files.newBufferedWriter;


public class Account {
    public String username = "";
    public String password = "";
    public History userHistory;
    public Favourites userFavourites;

    public Account(String username, String password, History previous_songs, Favourites favourites) {
        this.username = username;
        this.password = password;
        this.userHistory = previous_songs;
        this.userFavourites = favourites;
    }

    public Account() {
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getUserHistory() {
        return this.userHistory.toString();
    }
    public String getUserFavourites(){
        return this.userFavourites.toString();
    }

};
