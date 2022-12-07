package Presenters;

import Boundaries.SongRecOutputBoundary;
import Entities.Song;

import java.util.ArrayList;

public class SongRecPresenter implements SongRecOutputBoundary {

    ArrayList<Song> recommendedSongs;

    public SongRecPresenter(){
        recommendedSongs = new ArrayList<>();
    }

    /**
     * setter to store results of use case interactor processing to instance attribute
     *
     * @param recommendedSongList
     */
    @Override
    public void set5RecSongs(ArrayList<Song> recommendedSongList) {
        recommendedSongs = recommendedSongList;
    }

    /**
     * getter to be used by UI level
     *
     * @return
     */
    @Override
    public ArrayList<Song> get5RecSongs(){
        return recommendedSongs;
    }
}
