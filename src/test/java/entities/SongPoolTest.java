package Entities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SongPoolTest {

    SongPool songPool;
    String[] exampleStringArray;

    // before each is a method that runs before every test
    @BeforeEach
    void createExampleData(){
        songPool = new SongPool();
        exampleStringArray = new String[] {"Hey, Soul Sister","Train","neo mellow",
                "2010","97","89","67","-4","8","80","217","19","4","83"};

            // song, artist, genre,
        // year, BPM, energy, danceability, loudness, liveness, valence, length, acousticness, speechiness, popularity
    }

    // tags for tests themselves
    @Test
    void stringLineAlphabetCreatesSongWithAttributesSong(){
        assertEquals(songPool.readLine(exampleStringArray).song, "Hey, Soul Sister");
    }

    @Test
    void stringLineExampleFromSpotifyDatasetBPM(){
        assertEquals(songPool.readLine(exampleStringArray).bpm, "97");
    }

    @Test
    void stringLineExampleFromSpotifyDatasetValence(){
        assertEquals(songPool.readLine(exampleStringArray).valence, "80");
    }

    @Test
    void stringLineExampleFromSpotifyDatasetDanceability(){
        assertEquals(songPool.readLine(exampleStringArray).danceability, "67");
    }

    // after each method happens after every test
    @AfterEach
    void compareExampleData(){
        System.out.println("Test Completed");
    }
}