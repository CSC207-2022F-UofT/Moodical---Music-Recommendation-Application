package Processors;

import Entities.Account;
import Entities.History;
import Entities.Song;


import java.util.ArrayList;

public class HistoryProcessor {
    public static Account userAccount;
    public static void setAccount(Account account){
        HistoryProcessor.userAccount = account;
    }
    //use this to link to an account in the controllers and the UI


    public static ArrayList<Song> recommend(Account userAccount) {
        ArrayList<Song> new_playlist = new ArrayList<>();
        History history = HistoryProcessor.userAccount.userHistory;
        if (history.getPrevious_songs().size() <= 1)
            return history.getPrevious_songs().get(0);
        while (new_playlist.size() < 10) {
            int index = (int) ((Math.random() * ((history.getPrevious_songs().size() - 1))));
            ArrayList<Song> playlist = history.getPrevious_songs().get(index);
            int index2 = (int) ((Math.random() * 9));
            Song song = playlist.get(index2);
            if (!(new_playlist.contains(song))) {
                new_playlist.add(song);
            }
            addTo(new_playlist, userAccount);
        }
        return new_playlist;
    }


    //This function just reformats a History object's attribute previous_songs so that it's easier for processing
    //what will get passed to things such as display with just use the usual getter function in the History class
    public static ArrayList<Song> getAllSongs(Account userAccount) {
        ArrayList<Song> songs_so_far = new ArrayList<>();
        for (ArrayList<Song> playlist : HistoryProcessor.userAccount.userHistory.getPrevious_songs()) {
            for (Song song : playlist) {
                if (!(songs_so_far.contains(song))) {
                    songs_so_far.add(song);
                }
            }
        }
        return songs_so_far;
    }

    public static void addTo(ArrayList<Song> playlist, Account userAccount) {
        userAccount.userHistory.getPrevious_songs().add(playlist);
        // need to save to CSV file

    }

    public static ArrayList<String> get_song_strings(Account userAccount) {
        ArrayList<String> playlists = new ArrayList<>();
        for (ArrayList<Song> playlist : HistoryProcessor.userAccount.userHistory.getPrevious_songs()) {
            String newplaylist = " ";
            for (Song song : playlist) {
                newplaylist = newplaylist + song.song + " ";
            }
            playlists.add(newplaylist);
        }
        return playlists;
    }
}


