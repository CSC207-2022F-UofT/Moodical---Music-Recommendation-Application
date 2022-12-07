package Processors;
import Entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class UserAccountProcessing {
    public static File csvOfUsers;

    public UserAccountProcessing(File csvOfUsers) {
        UserAccountProcessing.csvOfUsers = csvOfUsers;
    }

    public static void writeAccountToCSV(String username, String password, History userHistory, Favourites userFavourites) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(UserAccountProcessing.csvOfUsers));
            writer.write("Username, Password, UserHistory, UserFavourites");

            writer.newLine();
            writer.write(username);
            writer.write(password);
            writer.write(userHistory.toString());
            writer.write(userFavourites.toString());
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Account> readAccountCSV() throws IOException {
        List<Account> users = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(UserAccountProcessing.csvOfUsers));
            String currentLine = br.readLine();
            while(currentLine != null) {
                String[] attributes = currentLine.split(",");
                Account user = createAccount(attributes);
                users.add(user);
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    // HELPER METHOD
    public static Account createAccount(String[] userData) {
        String username = userData[0];
        String password = userData[1];
        Song historySongs = createSongObject(userData[2]);
        ArrayList<String> favouriteSong = new ArrayList<String>();
        favouriteSong.add(userData[3]);

        ArrayList<Song> innerArray = new ArrayList<Song>();
        innerArray.add(historySongs);
        ArrayList<ArrayList<Song>> outerArray = new ArrayList<ArrayList<Song>>();
        outerArray.add(innerArray);

        History userHistory = new History(outerArray);
        Favourites userFavourites = new Favourites(favouriteSong);

        return new Account(username, password, userHistory, userFavourites);
    }

    public static Song createSongObject(String songAttributes) {
        String[] attributes = songAttributes.split(",");
        String songIn = attributes[0];
        String artistIn = attributes[1];
        String genreIn = attributes[2];
        String energyIn = attributes[3];
        String livenessIn = attributes[4];
        String valenceIn = attributes[5];
        String popularityIn = attributes[6];
        String danceabilityIn = attributes[7];
        String bpm = attributes[8];

        return new Song(songIn, artistIn, genreIn, energyIn, livenessIn, valenceIn, popularityIn, danceabilityIn, bpm);
    }

    public static Boolean returnUserExists(String username) throws IOException {
        List<Account> users = readAccountCSV();
        for (Account user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
}

