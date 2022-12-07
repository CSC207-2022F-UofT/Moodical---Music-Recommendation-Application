package processortests;

import Entities.Account;
import Entities.History;
import Entities.Song;
import Processors.HistoryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Processors.AnalysePlaylistProcessing;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalysisPlaylistTest {
    static ArrayList<Song> playlist = new ArrayList<>();
    static ArrayList<ArrayList<Song>> previousSongs =  new ArrayList<ArrayList<Song>>();
    static Account account = new Account();
    static ArrayList<String> songs = new ArrayList<>();

    // Results
    static  ArrayList<ArrayList<String>> result = new ArrayList<>();

    static Song song1 = new Song("Secrets","Savanna",
            "pop", "5", "2",
            "7", "6", "5", "5");
    static Song song2 = new Song("Secrets","Savanna",
            "pop", "5", "2",
            "7", "6", "5", "8");
    static Song song3 = new Song("Telephone","Savanna",
            "pop", "5", "2",
            "7", "6", "9", "10");
    static Song song4 = new Song("Someone like you","Adele",
            "dance pop", "5", "3",
            "7", "8", "9","5");
    static Song song5 = new Song("Hello","Adele",
            "pop", "2", "6",
            "5", "2", "6","30");
    static Song song6 = new Song("Born this way","Lady Gaga",
            "hip pop", "8", "8",
            "8", "8", "8", "6");
    static Song song7 = new Song("The one that got away","Katy Perry",
            "art pop", "2", "4",
            "1", "7", "1", "3");
    static Song song8 = new Song("Sparks","Coldplay",
            "acoustic pop", "2", "3",
            "2", "9", "0", "5");
    static Song song9 = new Song("Scientist","Coldplay",
            "boy band", "7", "6",
            "5", "9", "3","3");
    static Song song10 = new Song("Paradise","Coldplay",
            "pop", "5", "3",
            "8", "6", "2", "2");

@BeforeEach
void createExampleData(){
        playlist.add(song1);
        playlist.add(song2);
        playlist.add(song3);
        playlist.add(song4);
        playlist.add(song5);
        playlist.add(song6);
        playlist.add(song7);
        playlist.add(song8);
        playlist.add(song9);
        playlist.add(song10);
        previousSongs.add(playlist);
        account.userHistory = new History(previousSongs);
        songs.add("song song2 song3 song4 song5 song6 song7 song8 song9 song10 ");

        // Creating the expected
        ArrayList<String> artist = new ArrayList<>();
        artist.add("Coldplay");
        artist.add("Savanna");

        ArrayList<String> genre= new ArrayList<>();
        genre.add("pop");

        ArrayList<String> bpm= new ArrayList<>();
        bpm.add("7.7");

        ArrayList<String> dance = new ArrayList<>();
        dance.add("Someone like you");
        dance.add("Telephone");

        ArrayList<String> popular = new ArrayList<>();
        popular.add("Scientist");
        popular.add("Sparks");

        ArrayList<String> happy = new ArrayList<>();
        happy.add("Born this way");
        happy.add("Paradise");

        ArrayList<String> sad = new ArrayList<>();
        sad.add("The one that got away");

        ArrayList<String> mood = new ArrayList<>();
        mood.add("Born this way");

        result.add(artist);
        result.add(genre);
        result.add(bpm);
        result.add(dance);
        result.add(popular);
        result.add(happy);
        result.add(sad);
        result.add(mood);

        AnalysePlaylistProcessing.setAccount(account);
        HistoryProcessor.setAccount(account);
    }

    @Test
    void allData(){ assertEquals(result, AnalysePlaylistProcessing.getAllData());
    // This test covers all the tests for the other functions since it collects the output of the other function
        // return it as an arraylist
    }
}
