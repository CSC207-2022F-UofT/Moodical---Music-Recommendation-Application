package Processors;

import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;


import java.util.ArrayList;

public class HistoryProcessor {
    public static Account userAccount;

    public HistoryProcessor(){
        ArrayList<Song> playlist1 = new ArrayList<>();
        ArrayList<Song> playlist2 = new ArrayList<>();
        History history = new History(new ArrayList<>());
        Song song1 = new Song("Bad Romance","Lady Gaga","dance pop","2010","119","92","70","-4", "8");
        Song song2 = new Song("Just the Way You Are","Bruno Mars","pop","2010","109","84","64","-5","9");
        Song song3 = new Song("Only Girl (In The World)","Rihanna","barbadian pop","2010","126","72","79","-4","7");
        Song song4 = new Song("Cooler Than Me - Single Mix","Mike Posner","dance pop","2010","130","82","77","-5","70");
        Song song5 = new Song("Marry You","Bruno Mars","pop","2010","145","83","62","-5","10");
        playlist1.add(song1);
        playlist1.add(song2);
        playlist1.add(song3);
        playlist1.add(song4);
        playlist1.add(song5);
        Song song6 = new Song("Your Love Is My Drug","Kesha","dance pop","2010","120","61","83","-4","9");
        Song song7 = new Song("Take It Off","Kesha","dance pop","2010","125","68","73","-5","9" );
        Song song8 = new Song("Teenage Dream","Katy Perry","dance pop","2010","120","80","72","-5","13" );
        Song song9 = new Song("My First Kiss - feat. Ke$ha","3OH!3","dance pop","2010","138","89","68","-4","36");
        Song song10 = new Song("Sexy Bitch (feat. Akon)","David Guetta","dance pop","2010","130","63","81","-5","13");
        playlist2.add(song6);
        playlist2.add(song7);
        playlist2.add(song8);
        playlist2.add(song9);
        playlist2.add(song10);
        history.getPrevious_songs().add(playlist1);
        history.getPrevious_songs().add(playlist2);
        Favourites favourites = new Favourites(new ArrayList<>());
        this.userAccount = new Account("Derek Cresswell", "nox", history, favourites);
        }
    public static void setAccount(Account account){
        HistoryProcessor.userAccount = account;
    }
    //use this to link to an account in the controllers and the UI


    public static ArrayList<Song> recommend(Account userAccount) {
        ArrayList<Song> new_playlist = new ArrayList<>();
        History history = userAccount.userHistory;
        if (history.getPrevious_songs().size() <= 1)
            return history.getPrevious_songs().get(0);
        while (new_playlist.size() < 5) {
            int index = (int) ((Math.random() * (((history.getPrevious_songs().size()) - 1))));
            ArrayList<Song> playlist = history.getPrevious_songs().get(index);
            int index2 = (int) ((Math.random() * 4));
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
        for (ArrayList<Song> playlist : userAccount.userHistory.getPrevious_songs()) {
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


