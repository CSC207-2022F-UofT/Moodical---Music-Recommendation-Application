package Processors;

import Boundaries.FavouritesInputBoundary;
import Boundaries.FavouritesOutputBoundary;
import Entities.Account;

import java.util.ArrayList;

/**
 * Clean Arch Layer: UseCaseInteractor
 * implements the Favourites Input Boundary
 * takes output boundary as an instance attribute
 *
 */

public class FavouritesProcessor implements FavouritesInputBoundary {
    public Account userAccount;
    public FavouritesOutputBoundary presenter;


    /**
     * @param account
     * @param presenter
     * addSong (from the inputboundary)
     *  -adds song to user favourites
     *
     */
    public FavouritesProcessor(Account account, FavouritesOutputBoundary presenter){
        this.userAccount = account;
        this.presenter = presenter;
    }

    @Override
    public void addSong(String song) {
        if (!(userAccount.userFavourites.getFavourites().contains(song))) {
            userAccount.userFavourites.getFavourites().add(song);
            presenter.showSuccessScreen();
        }
    }


    /**
     * @param userAccount
     * @return
     *
     *  - used to format the favourites to be displayed when user clicks favourites
     *
     */
    public static String[][] toArray(Account userAccount) {
        ArrayList<String> songs = userAccount.userFavourites.getFavourites();
        String str_Array[] = new String[songs.size()];
        for (int j = 0; j < songs.size(); j++) {
            str_Array[j] = songs.get(j);
        }
        return new String[][]{str_Array};
    }
}




