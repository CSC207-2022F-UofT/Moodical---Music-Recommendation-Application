package Entities;
import java.util.ArrayList;

public class History implements Recommendable {
    public ArrayList<String> previous_songs;

    public History(){
        this.previous_songs = new ArrayList<String>();
    }
    @Override
    public ArrayList<String> recommend(){
        ArrayList<String> new_playlist = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((this.previous_songs.size()-1))));
            String song = this.previous_songs.get(index);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
        }
        return new_playlist;
    }


}
