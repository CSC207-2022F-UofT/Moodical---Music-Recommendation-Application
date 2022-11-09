package Entities;
import java.util.ArrayList;

public class SongPool {
    public ArrayList<Song> songs;

    public SongPool() {
        this.songs = new ArrayList<>();
    }

    public void populateSongPool(ReadableFile songFile) {
        Song[] songsReadFromFile = songFile.readFile(); //want readFile to return a list of Songs, we dont care how

    }

    public static void main(String[] args) {

    }
}
