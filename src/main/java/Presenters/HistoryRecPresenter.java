package Presenters;

import Boundaries.HistoryOutputBoundary;
import Entities.Song;
import Processors.HistoryProcessor;
import ResponseModels.HistoryResponseModel;
import UI.HistorySongRecWindow;
import UI.HistoryWindow;

import java.util.ArrayList;

public class HistoryRecPresenter implements HistoryOutputBoundary {
    public HistoryRecPresenter(){
    //HistorySongRecWindow.HistorySongRecWindow();
    }

    @Override
    public ArrayList<Song> generate(HistoryResponseModel response) {
        return response.getRecommendedPlaylist();
    }
}
