package Entities;

import java.util.ArrayList;

public class SongPool {
    private ArrayList<Song> songs;

    public SongPool() {
        this.songs = new ArrayList<>();
    }

    // Getter
    public ArrayList<Song> getSongList() {
        return this.songs;
    }

    public void populateSongPool(ReadableFile songFile, String filePath) {
        ArrayList<String> songsReadFromFile = songFile.readRows(filePath); //want readFile to return a list of Songs, we don't care how
        for (String readLine : songsReadFromFile) {
            String[] values = readLine.split(",");
            this.songs.add(readLine(values));
        }
    }

    // helper function
    public static Song readLine(String[] values) {
        Song newSong = new Song();

        newSong.song = values[0];
        newSong.artist = values[1];
        newSong.genre = values[2];
        newSong.energy = values[5];
        newSong.liveness = values[8];
        newSong.valence = values[9];
        newSong.popularity = values[13];
        newSong.danceability = values[6];
        newSong.bpm = values[4];

        return newSong;
    }
}

/// Arvin create it in the Song's constructor and return the new song