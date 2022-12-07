package Boundaries;

import Entities.Song;
import ResponseModels.QuestionnaireResponseModel;

import java.util.ArrayList;

public interface SongRecOutputBoundary {

    void set5RecSongs(ArrayList<Song> recommendedSongList);

    ArrayList<Song> get5RecSongs();
}
