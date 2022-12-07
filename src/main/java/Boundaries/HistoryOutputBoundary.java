package Boundaries;

import Entities.Song;

import java.util.ArrayList;

public interface HistoryOutputBoundary {
    /**
     * @param recommended
     * this is the function for the presenter
     */
    void generate(ArrayList<Song> recommended);

    ArrayList<Song> getRecommended();

}
