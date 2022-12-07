package Boundaries;

import Entities.Song;
import ResponseModels.QuestionnaireResponseModel;

import java.util.ArrayList;

public interface SongRecOutputBoundary {

    /**
     * Sets instance attribute of presenter to song list generated in the use case level
     *
     * @param recommendedSongList
     */
    void set5RecSongs(ArrayList<Song> recommendedSongList);

    /**
     * to be used by presenter as a getter to get the attribute containing generated song list
     *
     * @return
     */
    ArrayList<Song> get5RecSongs();
}
