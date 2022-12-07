package Presenters;

import Boundaries.HistoryOutputBoundary;
import Entities.Song;

import java.util.ArrayList;

public class HistoryRecPresenter implements HistoryOutputBoundary {
// never used due to issues connecting the classes but part of the design pattern
    public ArrayList<Song> recommendedPlaylist;

    @Override

    public void generate(ArrayList<Song> recommended) {
        this.recommendedPlaylist = recommended;
    }

    @Override
    public ArrayList<Song> getRecommended() {
        return this.recommendedPlaylist;
    }
}
