package processortests;

import Entities.Account;
import Entities.History;
import Entities.Song;
import Processors.HistoryProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {
    ArrayList<Song> playlist = new ArrayList<>();
    ArrayList<ArrayList<Song>> previousSongs =  new ArrayList<ArrayList<Song>>();
    History history = new History(previousSongs);
    Account account = new Account();
    ArrayList<String> songs = new ArrayList<>();
    Song song1 = new Song("song","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song2 = new Song("song2","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song3 = new Song("song3","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song4 = new Song("song4","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song5 = new Song("song5","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song6 = new Song("song6","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song7 = new Song("song7","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song8 = new Song("song8","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song9 = new Song("song9","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");
    Song song10 = new Song("song10","artist",
            "genre", "energy", "liveness",
            "valence", "popularity", "danceability");

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
        account.userHistory = history;
        songs.add(" song song2 song3 song4 song5 song6 song7 song8 song9 song10 ");

    }



    @Test
    void getStringSongs(){assertEquals(songs, HistoryProcessor.get_song_strings(account));
    }

    @Test
    void getReccomendations() {
        assertEquals(playlist, HistoryProcessor.recommend(account));
    }
}



