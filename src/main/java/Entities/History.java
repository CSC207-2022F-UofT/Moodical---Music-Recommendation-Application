package Entities;
import java.util.ArrayList;

/**
 * Clean Arch Level: Entities
 * stores the users past songs
 *
 */
public class History{
    private ArrayList<ArrayList<Song>> previous_songs;
    // a list of playlists a playlist is a list of strings

    /**
     * @param previous_songs
     * initalizes History
     */
    public History(ArrayList<ArrayList<Song>> previous_songs){
        this.previous_songs = previous_songs;
    }

    /**
     * @return
     * allows other classes to get the previous songs
     */
    public ArrayList<ArrayList<Song>> getPrevious_songs(){
        return this.previous_songs;
    }

}
