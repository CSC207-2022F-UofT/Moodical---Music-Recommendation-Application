package ResponseModels;

import Entities.Account;
import Entities.Favourites;
import Processors.FavouritesProcessor;

import java.util.ArrayList;

public class FavouritesResponseModel {
    private Account userAccount;

    private ArrayList<String> favourites = FavouritesProcessor.userAccount.userFavourites.getFavourites();
    public ArrayList<String> getFavourites(){
        return this.favourites;
    }
    public void setFavourites(ArrayList<String> favourites) {
        this.favourites = favourites;
    }

    public void addTo(String song){
        FavouritesProcessor.addTo(song, FavouritesProcessor.userAccount);
    }

}
