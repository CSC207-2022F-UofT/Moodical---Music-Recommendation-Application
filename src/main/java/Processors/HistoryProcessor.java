package main.java.Processors;

import main.java.Entities.History;
import main.java.Entities.Recommendable;

import java.util.ArrayList;

public class HistoryProcessor implements Recommendable {
    @Override
    public ArrayList<String> recommend(History songs){
        ArrayList<String> new_playlist = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((songs.previous_songs.size()-1))));
            String song = songs.previous_songs.get(index);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
        }
        return new_playlist;
    }
}
