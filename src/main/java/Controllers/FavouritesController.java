package Controllers;

import Entities.Favourites;
import Entities.History;
import Entities.Song;

import java.util.ArrayList;

public class FavouritesController{
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
        if (!(userFavourites.favourites.contains(song))){
            userFavourites.favourites.add(song);
        }
    }
}

