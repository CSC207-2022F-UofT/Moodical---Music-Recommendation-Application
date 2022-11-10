package Controllers;

import Entities.History;
import Entities.Song;

import java.util.ArrayList;

public class HistoryController {
    //by my understanding responds to buttons being pressed
    //needs to be called by whichever class generates the questionnaire

    public void addTo(ArrayList<Song> playlist, History userHistory){
        userHistory.previous_songs.add(playlist);
    }
}
