package processors;

import Entities.Song;
import Entities.SongPool;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class SongAnalysisProcessingTest {

    SongPool songPool;
    Song exampleSong1, exampleSong2, exampleSong3, exampleSong4;
    ArrayList<Song> songList = new ArrayList<Song>();


    @BeforeEach
    void createExampleData(){
        songPool = new SongPool();
        exampleSong1 = songPool.readLine(new String[] {"Hey, Soul Sister","Train","neo mellow",
                "2010","97","89","67","-4","8","80","217","19","4","83"});
        exampleSong2 = songPool.readLine(new String[] {"Hey, Soul Sister","Train","neo mellow",
                "2010","97","89","67","-4","8","80","217","19","4","83"});
        exampleSong3 = songPool.readLine(new String[] {"Hey, Soul Sister","Train","neo mellow",
                "2010","97","89","67","-4","8","80","217","19","4","83"});
        exampleSong4 = songPool.readLine(new String[] {"Hey, Soul Sister","Train","neo mellow",
                "2010","97","89","67","-4","8","80","217","19","4","83"});

        songPool.getSongList().add(exampleSong1);
        songPool.getSongList().add(exampleSong2);
        songPool.getSongList().add(exampleSong3);
        songPool.getSongList().add(exampleSong4);

        // song, artist, genre,
        // year, BPM, energy, danceability, loudness, liveness, valence, length, acousticness, speechiness, popularity
    }

}