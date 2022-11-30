package Entities;
import java.util.ArrayList;

public class History{
    private ArrayList<ArrayList<Song>> previous_songs;
    // a list of playlists a playlist is a list of strings
    public History(ArrayList<ArrayList<Song>> previous_songs){
        this.previous_songs = previous_songs;
    }

    public ArrayList<ArrayList<Song>> getPrevious_songs(){
        return this.previous_songs;
    }

}
