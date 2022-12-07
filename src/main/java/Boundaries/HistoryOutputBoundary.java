package Boundaries;

import Entities.Song;
import ResponseModels.HistoryResponseModel;

import java.util.ArrayList;

public interface HistoryOutputBoundary {
    ArrayList<Song> generate(HistoryResponseModel response);

}
