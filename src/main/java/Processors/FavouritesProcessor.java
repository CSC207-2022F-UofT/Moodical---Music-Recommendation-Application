package Processors;

import Boundaries.FavouritesInputBoundary;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;


import java.util.ArrayList;

public class FavouritesProcessor implements FavouritesInputBoundary {
    public static Account userAccount;

    public static void setAccount(Account account) {
        FavouritesProcessor.userAccount = account;
    }

    @Override
    public void addSong(String song) {
        if (!(userAccount.userFavourites.getFavourites().contains(song))) {
            userAccount.userFavourites.getFavourites().add(song);
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




