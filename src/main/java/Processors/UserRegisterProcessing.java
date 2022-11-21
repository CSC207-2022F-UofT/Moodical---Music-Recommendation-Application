package Processors;
import Entities.*;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UserRegisterProcessing {
    public static File csvOfUsers;
    public UserRegisterProcessing(Account account, File csvOfUsers) {
        UserRegisterProcessing.csvOfUsers = csvOfUsers;
    }

    public static void writeAccountToCSV(Account account) {
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
    public Object[] readAccountCSV(File csvOfUsers) throws IOException {
        List<String> eachLine = Files.readAllLines(csvOfUsers.toPath());
        return eachLine.toArray();
    }
    public static void createAccount(Account account) {
        writeAccountToCSV(account);
    }
}
