package Processors;

import Entities.Account;
import Entities.Favourites;
import Entities.Song;


import java.util.ArrayList;

public class FavouritesProcessor {
    public static Account userAccount;

    public static void setAccount(Account account) {
        FavouritesProcessor.userAccount = account;
    }

    public void addTo(String song, Account userAccount) {
        if (!(userAccount.userFavourites.getFavourites().contains(song))) {
            userAccount.userFavourites.getFavourites().add(song);
        }
    }

    public static String[][] toArray(Account userAccount) {
        ArrayList<String> songs = FavouritesProcessor.userAccount.userFavourites.getFavourites();
        String str_Array[] = new String[songs.size()];
        for (int j = 0; j < songs.size(); j++) {
            str_Array[j] = songs.get(j);
        }
        return new String[][]{str_Array};
    }
}




