package entities;
import java.util.ArrayList;

public class History{
    private ArrayList<ArrayList<Song>> previous_songs;
    // a list of playlists a playlist is a list of strings
    public History(){
        this.previous_songs = new ArrayList<ArrayList<Song>>();
    }

    public ArrayList<ArrayList<Song>> getPrevious_songs(){
        return this.previous_songs;
    }

}
