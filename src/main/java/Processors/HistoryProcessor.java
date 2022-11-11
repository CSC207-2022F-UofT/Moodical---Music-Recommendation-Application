package Processors;

import Entities.History;
import Entities.Recommendable;
import Entities.Song;
import Controllers.HistoryController;

import java.util.ArrayList;

public class HistoryProcessor implements Recommendable {
    @Override
    public ArrayList<Song> recommend(Object songs){
        ArrayList<Song> new_playlist = new ArrayList<>();
        History history = ((History)songs);
        while(new_playlist.size() < 10){
            int index = (int) ((Math.random() * ((history.getPrevious_songs().size()-1))));
            ArrayList<Song> playlist = history.getPrevious_songs().get(index);
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


    //This function just reformats a History object's attribute previous_songs so that it's easier for processing
    //what will get passed to things such as display with just use the usual getter function in the History class
    public ArrayList<Song> getAllSongs(History history){
        ArrayList<Song> songs_so_far = new ArrayList<>();
        for(ArrayList<Song> playlist : history.getPrevious_songs()){
            for(Song song : playlist){
                if (!(songs_so_far.contains(song))){
                    songs_so_far.add(song);
                }
            }
        }
        return songs_so_far;
    }



 }

