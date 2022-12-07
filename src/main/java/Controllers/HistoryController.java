package Controllers;

import Boundaries.HistoryInputBoundary;
import Entities.Song;
import Processors.HistoryProcessor;
import RequestModels.UserAccountRequestModel;

import java.util.ArrayList;

public class HistoryController {
    public HistoryInputBoundary processor;

    public HistoryController(HistoryInputBoundary processor)
    {this.processor = processor;}

    public void generate(ArrayList<Song> recommendedPlaylist){
        processor.getRecommended();
    }

}
