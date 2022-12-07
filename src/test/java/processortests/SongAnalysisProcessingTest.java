package processortests;

import Presenters.SongRecPresenter;
import Processors.SongAnalysisProcessing;
import Entities.Song;
import Entities.SongPool;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class SongAnalysisProcessingTest {
    /**
     * The test verifies that given a song pool, this class' methods will call the correct song type
     * (very sad, sad, happy, very happy)
     */

    SongPool songPool;
    Song exampleSong1, exampleSong2, exampleSong3, exampleSong4;
    ArrayList<Song> songList = new ArrayList<Song>();

    SongAnalysisProcessing songProcessing;


    @BeforeEach
    void createExampleData(){
        songPool = new SongPool();
        exampleSong1 = songPool.readLine(new String[] {"Pom Poms","Jonas Brothers","boy band",
                "2013","148","98","68","-2","28","90","198","7","9","52"});
        exampleSong2 = songPool.readLine(new String[] {"Hey, Soul Sister","Train","neo mellow",
                "2010","97","89","67","-4","8","80","217","19","4","83"});
        exampleSong3 = songPool.readLine(new String[] {"Someone Like You","Adele","british soul",
                "2011","135","33","56","-8","10","28","285","89","3","80"});
        exampleSong4 = songPool.readLine(new String[] {"Say Something","A Great Big World","neo mellow",
                "2014","138","15","45","-9","9","9","229","87","3","61"});

        songPool.getSongList().add(exampleSong1);
        songPool.getSongList().add(exampleSong2);
        songPool.getSongList().add(exampleSong3);
        songPool.getSongList().add(exampleSong4);

        // song, artist, genre,
        // year, BPM, energy, danceability, loudness, liveness, valence, length, acousticness, speechiness, popularity

        songProcessing = new SongAnalysisProcessing(new SongRecPresenter(), songPool);
    }
    @Test
    void getVeryHappySong(){
        assertEquals(exampleSong1, songProcessing.getSong(9.5));
    }

    @Test
    void getHappySong(){
        assertEquals(exampleSong2, songProcessing.getSong(8.0));
    }

    @Test
    void getSadSong(){
        assertEquals(exampleSong3, songProcessing.getSong(4.5));
    }

    @Test
    void getVerySadSong(){
        assertEquals(exampleSong4, songProcessing.getSong(2.0));
    }

    @AfterEach
    void testMessage(){
        System.out.println("Test Complete");
    }

}