package Presenters;

import Boundaries.HistoryOutputBoundary;
import Entities.Song;
import Processors.HistoryProcessor;
import ResponseModels.HistoryResponseModel;
import UI.HistoryWindow;

import java.util.ArrayList;

public class HistoryPresenter implements HistoryOutputBoundary {
    public HistoryPresenter(){
        String [][] tabledata = HistoryProcessor.toArray(HistoryProcessor.userAccount);
        HistoryWindow.Hwindow();
    }

    @Override
    public ArrayList<Song> generate(HistoryResponseModel response) {
        return response.getRecommendedPlaylist();
    }
}
