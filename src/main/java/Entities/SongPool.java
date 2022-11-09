package Entities;
import java.util.ArrayList;

public class SongPool {
    public ArrayList<Song> songs;

    public SongPool() {
        this.songs = new ArrayList<>();
    }

    public void populateSongPool(ReadableFile songFile) {
        Song[] songsReadFromFile = songFile.readFile(); //want readFile to return a list of Songs, we don't care how
        for (Song readSong : songsReadFromFile) {
            this.songs.add(readSong);
        }
    }

}
