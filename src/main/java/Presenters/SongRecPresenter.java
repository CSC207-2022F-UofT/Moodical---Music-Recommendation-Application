package Presenters;

import Boundaries.SongRecOutputBoundary;
import Entities.Song;

import java.util.ArrayList;

public class SongRecPresenter implements SongRecOutputBoundary {

    ArrayList<Song> recommendedSongs;

    public SongRecPresenter(){
        recommendedSongs = new ArrayList<>();
    }
    @Override
    public void set5RecSongs(ArrayList<Song> recommendedSongList) {
        recommendedSongs = recommendedSongList;
    }
    @Override
    public ArrayList<Song> get5RecSongs(){
        return recommendedSongs;
    }
}
