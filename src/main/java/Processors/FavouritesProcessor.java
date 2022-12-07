package Processors;

import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;


import java.util.ArrayList;

public class FavouritesProcessor {
    public static Account userAccount;
    public FavouritesProcessor(){
        ArrayList<Song> playlist1 = new ArrayList<>();
        ArrayList<Song> playlist2 = new ArrayList<>();
        History history = new History(new ArrayList<>());
        Song song1 = new Song("Bad Romance","Lady Gaga","dance pop","2010","119","92","70","-4", "8");
        Song song2 = new Song("Just the Way You Are","Bruno Mars","pop","2010","109","84","64","-5","9");
        Song song3 = new Song("Only Girl (In The World)","Rihanna","barbadian pop","2010","126","72","79","-4","7");
        Song song4 = new Song("Cooler Than Me - Single Mix","Mike Posner","dance pop","2010","130","82","77","-5","70");
        Song song5 = new Song("Marry You","Bruno Mars","pop","2010","145","83","62","-5","10");
        playlist1.add(song1);
        playlist1.add(song2);
        playlist1.add(song3);
        playlist1.add(song4);
        playlist1.add(song5);
        Song song6 = new Song("Your Love Is My Drug","Kesha","dance pop","2010","120","61","83","-4","9");
        Song song7 = new Song("Take It Off","Kesha","dance pop","2010","125","68","73","-5","9" );
        Song song8 = new Song("Teenage Dream","Katy Perry","dance pop","2010","120","80","72","-5","13" );
        Song song9 = new Song("My First Kiss - feat. Ke$ha","3OH!3","dance pop","2010","138","89","68","-4","36");
        Song song10 = new Song("Sexy Bitch (feat. Akon)","David Guetta","dance pop","2010","130","63","81","-5","13");
        playlist2.add(song6);
        playlist2.add(song7);
        playlist2.add(song8);
        playlist2.add(song9);
        playlist2.add(song10);
        history.getPrevious_songs().add(playlist1);
        history.getPrevious_songs().add(playlist2);
        Favourites favourites = new Favourites(new ArrayList<>());
        FavouritesProcessor.userAccount = new Account("Derek Cresswell", "nox", history, favourites);
    }

    public static void setAccount(Account account) {
        FavouritesProcessor.userAccount = account;
    }

    public static void addTo(String song, Account userAccount) {
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




