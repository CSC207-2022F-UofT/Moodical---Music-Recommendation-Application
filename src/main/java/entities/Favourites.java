package entities;
import java.util.ArrayList;

public class Favourites{
    private ArrayList<Song> favourites;

    public Favourites(ArrayList<Song> favourites){
        this.favourites = favourites;
    }

    public ArrayList<Song> getFavourites(){
        return this.favourites;
    }




}
