package Boundaries;

import Entities.Song;

import java.util.ArrayList;

public interface HistoryOutputBoundary {
    void generate(ArrayList<Song> recommended);

    ArrayList<Song> getRecommended();

}
