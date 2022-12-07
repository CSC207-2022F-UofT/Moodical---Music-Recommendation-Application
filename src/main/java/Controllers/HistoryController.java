package Controllers;

import Boundaries.HistoryInputBoundary;
import Entities.Song;
import java.util.ArrayList;

/**
 * Clean Arch Level: Controller
 * called by the UI
 * takes processor instance attribute
 *
 */
public class HistoryController {
    public HistoryInputBoundary processor;

    /**
     * @param processor
     * constructor
     */
    public HistoryController(HistoryInputBoundary processor)
    {this.processor = processor;}

    /**
     * @param recommendedPlaylist
     * gets the recommended playlist based on the users History
     */
    public void generate(ArrayList<Song> recommendedPlaylist){
        processor.getRecommended();
    }

}
