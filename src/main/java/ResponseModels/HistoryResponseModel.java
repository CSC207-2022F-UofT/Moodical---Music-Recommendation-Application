package ResponseModels;

import entities.Song;
import Processors.HistoryProcessor;

import java.util.ArrayList;
import entities.Account;

public class HistoryResponseModel {

    private Account userAccount;
    ArrayList<Song> recommendedPlaylist = HistoryProcessor.recommend(userAccount);

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

