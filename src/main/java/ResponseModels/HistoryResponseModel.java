package ResponseModels;

import Boundaries.HistoryOutputBoundary;
import Entities.Song;
import Processors.HistoryProcessor;

import java.util.ArrayList;
import Entities.Account;

public class HistoryResponseModel {
    private ArrayList<Song> recommendedPlaylist;
//    private ArrayList<ArrayList<Song>> previousSongs;

    public ArrayList<Song> getRecommendedPlaylist() {
        return recommendedPlaylist;
    }
    public void setRecommendedPlaylist(ArrayList<Song> recommendedPlaylist) {
        this.recommendedPlaylist = recommendedPlaylist;

    }


//    private ArrayList<Song> allSongs = HistoryProcessor.getAllSongs(HistoryProcessor.userAccount);

    //    public ArrayList<Song> getAllSongs(){
//        return allSongs;
//    }
    // also not needed by any presenters


//    public void setAllSongs(ArrayList<Song> allSongs) {
//        this.allSongs = allSongs;
//    }


}




