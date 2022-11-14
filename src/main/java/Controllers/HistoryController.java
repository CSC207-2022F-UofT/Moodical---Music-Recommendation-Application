package Controllers;

import Entities.Account;
import Entities.History;
import Entities.Song;

import java.util.ArrayList;

public class HistoryController {
    //by my understanding responds to buttons being pressed
    //needs to be called by whichever class generates the questionnaire

    public static void addTo(ArrayList<Song> playlist, Account userAccount){
        userAccount.userHistory.getPrevious_songs().add(playlist);
    }
}
