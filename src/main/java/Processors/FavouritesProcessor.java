package main.java.Processors;

import main.java.Entities.Favourites;
import main.java.Entities.History;
import main.java.Entities.Recommendable;

import java.util.ArrayList;

public class FavouritesProcessor implements Recommendable {

    @Override
    public ArrayList<String> recommend(History songs){
        ArrayList<String> new_playlist = new ArrayList<String>();
        Favourites favourites = ((Favourites)songs);
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((favourites.favourites.size()-1))));
            String song = favourites.favourites.get(index);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
        }
        return new_playlist;
    }
}
