package Entities;
import java.util.ArrayList;

/**
 * Clean Architecture layer: Entities
 * stores a users favourite songs as an ArrayList<String>
 *
 */

public class Favourites{
    private ArrayList<String> favourites;

    /**
     * @param favourites
     */
    public Favourites(ArrayList<String> favourites){
        this.favourites = favourites;
    }

    /**
     * @return
     */
    public ArrayList<String> getFavourites(){
        return this.favourites;
    }




}
