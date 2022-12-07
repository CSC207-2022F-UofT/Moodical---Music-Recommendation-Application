package Processors;

import Boundaries.FavouritesInputBoundary;
import Boundaries.FavouritesOutputBoundary;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;
import Presenters.FavouritesPresenter;


import java.util.ArrayList;

public class FavouritesProcessor implements FavouritesInputBoundary {
    public Account userAccount;
    public FavouritesOutputBoundary presenter;

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

    public static String[][] toArray(Account userAccount) {
        ArrayList<String> songs = userAccount.userFavourites.getFavourites();
        String str_Array[] = new String[songs.size()];
        for (int j = 0; j < songs.size(); j++) {
            str_Array[j] = songs.get(j);
        }
        return new String[][]{str_Array};
    }
}




