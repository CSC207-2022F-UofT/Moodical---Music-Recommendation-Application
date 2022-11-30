package Presenters;

import Boundaries.SongRecOutputBoundary;
import Entities.Song;
import ResponseModels.SongRecResponseModel;

import java.util.ArrayList;

public class SongRecPresenter implements SongRecOutputBoundary {
    @Override
    public SongRecResponseModel generate(SongRecResponseModel response) {
        ArrayList<Song> songs = response.get5RandSongs();
        response.setRecSongs(songs);
        return response;
    }
}
