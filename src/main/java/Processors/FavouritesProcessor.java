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
        for (int i = 0; i < 10; i++) {
            int index = (int) ((Math.random() * ((favourites.favourites.size() - 1))));
            Song song = favourites.favourites.get(index);
            if (!(new_playlist.contains(song))) {
                new_playlist.add(song);
            }
            //HistoryController.addTo(new_playlist, userHistory);
            //unclear how to access the specific accounts user history
        }
        return new_playlist;
    }
}




// some thoughts, maybe having a song class
// a playlist is an array of song objects
// song class: a song is a string that has an attributes: mood, favourite, and title
// the title simply being a string with the name of the song
// mood attributes for a song would be a number regarding the mood it correlates to like in the data set we found
// could be useful for analyzing playlists
//favourite attribute is boolean
// means if in the UI the user hits "favourite" favourite will be set to true
// this means the favourites processor can iterate through a list of songs and add any with favourites = true
// to be in the favourites entity associated with the user


// also account shouldn't extend history just import the class,
// it doesn't extend as it doesn't have any of the same attributes or functions
