package Entities;
import java.util.ArrayList;

public class Favourites extends History {
    public ArrayList<String> favourites;

    public Favourites(ArrayList<String> favourites){
        super();
        this.favourites = favourites;
    }


    @Override
    public ArrayList<String> recommend(){
        ArrayList<String> new_playlist = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((this.favourites.size()-1))));
            String song = this.favourites.get(index);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
        }
        return new_playlist;
    }
}
