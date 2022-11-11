package Processors;

import Entities.Recommendable;
import Entities.Favourites;
import Entities.Song;
import Controllers.HistoryController;


import java.util.ArrayList;

public class FavouritesProcessor implements Recommendable {

    @Override
    //reccommends playlist and adds playlist to history
    public ArrayList<Song> recommend(Object songs) {
        ArrayList<Song> new_playlist = new ArrayList<Song>();
        Favourites favourites = ((Favourites) songs);
        while(new_playlist.size() < 10){
            int index = (int) ((Math.random() * ((favourites.getFavourites().size() - 1))));
            Song song = favourites.getFavourites().get(index);
            if (!(new_playlist.contains(song))) {
                new_playlist.add(song);
            }
            //HistoryController.addTo(new_playlist, userHistory);
            //unclear how to access the specific accounts user history
        }
        return new_playlist;
    }
}

