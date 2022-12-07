package Processors;

import Boundaries.HistoryInputBoundary;
import Boundaries.HistoryOutputBoundary;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;


import java.util.ArrayList;

public class HistoryProcessor implements HistoryInputBoundary {
    public static Account userAccount;
    public HistoryOutputBoundary presenter;

    public static void setAccount(Account account){
        userAccount = account;
    }

    public HistoryProcessor(Account account, HistoryOutputBoundary presenter){
        this.userAccount = account;
        this.presenter = presenter;
    }
    //use this to link to an account in the controllers and the UI

    @Override
    public void getRecommended() {
        ArrayList<Song> new_playlist = new ArrayList<>();
        History history = userAccount.userHistory;
        if (history.getPrevious_songs().size() <= 1)
            this.presenter.generate(history.getPrevious_songs().get(0));
        for (int i = 0; i < 5; i++) {
            int index = (int) ((Math.random() * (((history.getPrevious_songs().size()) - 1))));
            ArrayList<Song> playlist = history.getPrevious_songs().get(index);
            int index2 = (int) ((Math.random() * 4));
            Song song = playlist.get(index2);
            if (!(new_playlist.contains(song))) {
                new_playlist.add(song);
            }
            addTo(new_playlist, userAccount);
        }
        this.presenter.generate(new_playlist);
    }
    public static void addTo(ArrayList<Song> playlist, Account userAccount) {
        userAccount.userHistory.getPrevious_songs().add(playlist);
        // need to save to CSV file

        // all below code just reformats the information in order to make it readable for analysis
    }

    //This function just reformats a History object's attribute previous_songs so that it's easier for processing
    //what will get passed to things such as display with just use the usual getter function in the History class
    public static ArrayList<Song> getAllSongs(Account userAccount) {
        ArrayList<Song> songs_so_far = new ArrayList<>();
        for (ArrayList<Song> playlist : userAccount.userHistory.getPrevious_songs()) {
            for (Song song : playlist) {
                if (!(songs_so_far.contains(song))) {
                    songs_so_far.add(song);
                }
            }
        }
        return songs_so_far;
    }

    public static ArrayList<String> get_song_strings(Account account) {
        ArrayList<String> playlists = new ArrayList<String>();
        for (ArrayList<Song> playlist : account.userHistory.getPrevious_songs()) {
            String newplaylist = " ";
            for (Song song : playlist) {
                newplaylist = newplaylist + song.song + " ";
            }
            playlists.add(newplaylist);
        }
        return playlists;
    }
    public static String[][] toArray(Account account) {
        ArrayList<String> songs = HistoryProcessor.get_song_strings(account);
        String[] str_Array = new String[songs.size()];
        for (int j = 0; j < songs.size(); j++) {
            str_Array[j] = songs.get(j);
        }
        return new String[][]{str_Array};
    }


}


