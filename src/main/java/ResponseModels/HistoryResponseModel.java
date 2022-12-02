package ResponseModels;

import Boundaries.HistoryOutputBoundary;
import Entities.Song;
import Processors.HistoryProcessor;

import java.util.ArrayList;
import Entities.Account;

public class HistoryResponseModel {

    private Account userAccount;
    private ArrayList<Song> recommendedPlaylist = HistoryProcessor.recommend(userAccount);

    ArrayList<Song> allSongs = HistoryProcessor.getAllSongs(userAccount);

    public ArrayList<Song> getAllSongs(){
        return allSongs;
    }
    public ArrayList<Song> getRecommendedPlaylist(){
        return recommendedPlaylist;
    }

    public void setAllSongs(ArrayList<Song> allSongs){
        this.allSongs = allSongs;
    }
    public void setRecommendedPlaylist(ArrayList<Song> recommendedPlaylist){
        this.recommendedPlaylist = recommendedPlaylist;
    }



}


