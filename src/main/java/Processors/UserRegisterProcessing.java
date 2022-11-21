package Processors;
import Entities.*;

import java.io.*;
import java.util.ArrayList;

public class UserRegisterProcessing extends Account {
    public File csvOfUsers;
}
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

            ArrayList<Song> allHistorySongs = HistoryProcessor.getAllSongs(account);
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

    public ArrayList<String> readAccountCSV(File csvOfUsers) {
        // need to create a Reader Method
    }
    public void createAccount(Account account) {
        writeAccountToCSV(account);
    }
}
