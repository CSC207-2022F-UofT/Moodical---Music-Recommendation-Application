package Processors;

import Entities.History;
import Entities.Recommendable;
import Entities.Song;
import Controllers.HistoryController;

import java.util.ArrayList;

public class HistoryProcessor implements Recommendable {
    @Override
    public ArrayList<Song> recommend(Object songs){
        ArrayList<Song> new_playlist = new ArrayList<Song>();
        History history = ((History)songs);
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((history.previous_songs.size()-1))));
            ArrayList<Song> playlist = history.previous_songs.get(index);
            int index2 = (int) ((Math.random() * 9));
            Song song = playlist.get(index2);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
            //HistoryController.addTo(new_playlist, userHistory);
            //unclear how to access the specific accounts user history
        }
        return new_playlist;
    }



 }

