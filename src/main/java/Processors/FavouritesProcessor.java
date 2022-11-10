package Processors;

import Entities.Recommendable;
import Entities.Favourites;
import Entities.History;
import Entities.Song;

import java.util.ArrayList;

public class FavouritesProcessor implements Recommendable {

    @Override
    public ArrayList<Song> recommend(Object songs){
        ArrayList<Song> new_playlist = new ArrayList<Song>();
        Favourites favourites = ((Favourites)songs);
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((favourites.favourites.size()-1))));
            Song song = favourites.favourites.get(index);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
        }
        return new_playlist;
    }

    // similar to history this function gets called whenever someone adds something to favourites
    // unsure when this will be called in terms of other classes
    // do we need like a save changes button or smth so like say we enter history, we click on a playlist, we start
    //to add things to favourites but don't have a direct way to immediately add that song,
    // so if we have a save changes button
    // once they've clicked everything they want in favourites ( thus change the boolean attribute of that song to true
    //this function gets called we cycle through the playlist and each favourited song gets added

    public void addTo(ArrayList<Song> playlist, Favourites userFavourites){
        for(Song song : playlist){
            if(song.favourite == true){
                userFavourites.favourites.add(song);
            }
        }

    }

    // alternatively we have the ui pass each song to this function immediately not sure if this utilized the attribute
    //or if we should eliminate it altogether
    public void addToFavourites(Song song, Favourites userFavourites){
        userFavourites.favourites.add(song);
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
