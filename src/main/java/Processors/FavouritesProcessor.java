package Processors;

import Entities.Account;
import Entities.Favourites;
import Entities.Song;


import java.util.ArrayList;

public class FavouritesProcessor {
    public static Account userAccount;
    public static void setAccount(Account account){
        FavouritesProcessor.userAccount = account;
    }

    //recommends playlist and adds playlist to history
    public ArrayList<Song> recommend(Object songs, Account userAccount) {
        ArrayList<Song> new_playlist = new ArrayList<Song>();
        Favourites favourites = ((Favourites) songs);
        if(favourites.getFavourites().size() < 10){
            new_playlist = favourites.getFavourites();
            return new_playlist;
        }
        while (new_playlist.size() < 10) {
            int index = (int) ((Math.random() * ((favourites.getFavourites().size() - 1))));
            Song song = favourites.getFavourites().get(index);
            if (!(new_playlist.contains(song))) {
                new_playlist.add(song);
            }
            HistoryProcessor.addTo(new_playlist, userAccount);

        }
        return new_playlist;
    }

    public void addTo(Song song, Account userAccount) {
        if (!(userAccount.userFavourites.getFavourites().contains(song))) {
            userAccount.userFavourites.getFavourites().add(song);
        }
    }
    public static ArrayList<String> get_song_strings(Account userAccount) {
        ArrayList<String> favouriteslist = new ArrayList<>();
        for (Song song : FavouritesProcessor.userAccount.userFavourites.getFavourites()){
            favouriteslist.add(song.song);
        }
        return favouriteslist;

    }
    public static String[][] toArray(Account userAccount) {
        ArrayList<String> songs = FavouritesProcessor.get_song_strings(userAccount);
        String str_Array[] = new String[songs.size()];
        for (int j = 0; j < songs.size(); j++) {
            str_Array[j] = songs.get(j);
        }
        return new String[][]{str_Array};
}




