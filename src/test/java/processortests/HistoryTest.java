package processortests;

import Entities.Account;
import Entities.History;
import Entities.Song;
import Processors.HistoryProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HistoryTest {
    ArrayList<Song> playlist = new ArrayList<>();
    ArrayList<Song> playlist2 = new ArrayList<>();
    ArrayList<ArrayList<Song>> previousSongs =  new ArrayList<ArrayList<Song>>();
    History history = new History(previousSongs);
    Account account = new Account();
    ArrayList<String> songs = new ArrayList<>();

    ArrayList<String> allsongs = new ArrayList<>();
    Song song1 = new Song("song","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability", "5");
    Song song2 = new Song("song2","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability","5");
    Song song3 = new Song("song3","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability","7");
    Song song4 = new Song("song4","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability","4");
    Song song5 = new Song("song5","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability","9");
    Song song6 = new Song("song6","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability","5");
    Song song7 = new Song("song7","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability","3");
    Song song8 = new Song("song8","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability", "2");
    Song song9 = new Song("song9","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability", "1");
    Song song10 = new Song("song10","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability", "3");

    @BeforeEach
    void createExampleData(){
        playlist.add(song1);
        playlist.add(song2);
        playlist.add(song3);
        playlist.add(song4);
        playlist.add(song5);
        playlist2.add(song6);
        playlist2.add(song7);
        playlist2.add(song8);
        playlist2.add(song9);
        playlist2.add(song10);
        allsongs.add(song1.song);
        allsongs.add(song2.song);
        allsongs.add(song3.song);
        allsongs.add(song4.song);
        allsongs.add(song5.song);
        allsongs.add(song6.song);
        allsongs.add(song7.song);
        allsongs.add(song8.song);
        allsongs.add(song9.song);
        allsongs.add(song10.song);



        previousSongs.add(playlist);
        account.userHistory = history;
        songs.add(" song song2 song3 song4 song5 ");

    }



    @Test
    void getStringSongs(){assertEquals(songs, HistoryProcessor.get_song_strings(account));
    }

    @Test
    void getRecommendations() {
        ArrayList<Song> reccomended = HistoryProcessor.recommend(account);
        assertEquals(playlist, reccomended);
    }

    @Test
    void addToTest(){
        ArrayList<ArrayList<Song>> newPreviousSongs = previousSongs;
        newPreviousSongs.add(playlist2);
        HistoryProcessor.addTo(playlist2, account);
        assertEquals(newPreviousSongs, account.userHistory.getPrevious_songs());
    }

    @Test //testing the recommendation function when there is more than one playlist included in History
    void getRecommendations2() {
        HistoryProcessor.addTo(playlist2, account);
        ArrayList<Song> newPlaylist = HistoryProcessor.recommend(account);
        boolean result = true;
        for(Song song: newPlaylist){
            if (!(allsongs.contains(song.song))) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }
}



