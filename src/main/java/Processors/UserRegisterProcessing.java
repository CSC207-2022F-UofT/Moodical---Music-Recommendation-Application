package Processors;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class UserRegisterProcessing extends Account {
    HashMap<String, String> AllUsers = new HashMap<String, String>();
    private final File csvOfUsers;
    public UserRegisterProcessing(String username, String password, History previous_songs, Favourites favourites, File csvOfUsers) {
        super(username, password, previous_songs, favourites);
        this.csvOfUsers = csvOfUsers;
    }

    public void writeAccountToCSV(Account account) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvOfUsers));
            writer.write("Username, Password, UserHistory, UserFavourites");
            writer.newLine();

            ArrayList<Song> allHistorySongs = HistoryProcessor.getAllSongs(account.userHistory);
            String allHistorySongsAsAString = String.valueOf(allHistorySongs);
            String allFavouritesSongsAsAString = String.valueOf(account.userFavourites.getFavourites());

            writer.write(account.username);
            writer.write(account.password);
            writer.write(allHistorySongsAsAString);
            writer.write(allFavouritesSongsAsAString);
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        // Reading method?

    public void createAccount(Account account) {
        writeAccountToCSV(account);
        AllUsers.put(account.username, account.password);
    }

    public boolean createNewAccount(Account account) {
        if (!(AllUsers.containsKey(account.username))) {
            createAccount(account);
            return true;
        }
        return false;
    }

        public void MapAllAccounts(String username, String password) {
        AllUsers.put(username, password);
    }

    public boolean checkUserExists(String username) {
        return AllUsers.containsKey(username);
    }



}
