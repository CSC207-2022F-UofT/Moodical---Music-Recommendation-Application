package Processors;

import entities.Account;
import entities.Favourites;
import entities.Song;


import java.util.ArrayList;

public class FavouritesProcessor {

    //recommends playlist and adds playlist to history
    public ArrayList<Song> recommend(Object songs, Account userAccount) {
        ArrayList<Song> new_playlist = new ArrayList<Song>();
        Favourites favourites = ((Favourites) songs);
        if(favourites.getFavourites().size() < 10){
            new_playlist = favourites.getFavourites();
            return new_playlist;
        }
        while (new_playlist.size() < 10) {
            int index = (int) ((Math.random() * ((favourites.getFavourites().size() - 1))));
            Song song = favourites.getFavourites().get(index);
            if (!(new_playlist.contains(song))) {
                new_playlist.add(song);
            }
            HistoryProcessor.addTo(new_playlist, userAccount);

        }
        return new_playlist;
    }

    public void addTo(Song song, Account userAccount) {
        if (!(userAccount.userFavourites.getFavourites().contains(song))) {
            userAccount.userFavourites.getFavourites().add(song);
        }
    }
}



