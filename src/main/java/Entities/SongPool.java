package Entities;
import java.util.ArrayList;

public class SongPool {
    public ArrayList<Song> songs;

    public SongPool() {
        this.songs = new ArrayList<>();
    }

    public void populateSongPool(ArrayList<Song> readSongs) {
        for (Song song : readSongs) {
            this.songs.add(song);
        }
    }

    public static void main(String[] args) {

    }
}
