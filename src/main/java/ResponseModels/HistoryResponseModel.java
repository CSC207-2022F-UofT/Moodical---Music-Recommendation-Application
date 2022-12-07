package ResponseModels;

import Boundaries.HistoryOutputBoundary;
import Entities.Song;
import Processors.HistoryProcessor;

import java.util.ArrayList;
import Entities.Account;

public class HistoryResponseModel {
    private ArrayList<Song> recommendedPlaylist = HistoryProcessor.recommend(HistoryProcessor.userAccount);

    ArrayList<Song> allSongs = HistoryProcessor.getAllSongs(HistoryProcessor.userAccount);

//    public ArrayList<Song> getAllSongs(){
//        return allSongs;
//    }
    // also not needed by any presenters
    public ArrayList<Song> getRecommendedPlaylist(){
        return recommendedPlaylist;
    }

    public void setAllSongs(ArrayList<Song> allSongs){
        this.allSongs = allSongs;
    }

//    public void setRecommendedPlaylist(ArrayList<Song> recommendedPlaylist){
//        this.recommendedPlaylist = recommendedPlaylist;
    // user should never set a recommended playlist
    }




