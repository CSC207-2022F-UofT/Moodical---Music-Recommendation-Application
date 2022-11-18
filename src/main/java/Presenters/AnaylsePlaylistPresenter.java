package Presenters;

import ResponseModels.AnalysePlaylistResponseModel;
import Boundaries.OutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

public class AnaylsePlaylistPresenter implements OutputBoundary {
    @Override
    public AnalysePlaylistResponseModel analysePlaylist(AnalysePlaylistResponseModel getAnalysed){

        ArrayList<String> mostArtists = getAnalysed.getMostArtist();
        ArrayList<String> mostGenre = getAnalysed.getMostGenre();
        double averageBmp = getAnalysed.getAverageBmp();
        ArrayList<String> mostDanceable = getAnalysed.getMostDanceable();
        ArrayList<String> mostPopular = getAnalysed.getMostPopular();
        ArrayList<String> happiest = getAnalysed.getHappiest();
        ArrayList<String> saddest = getAnalysed.getSaddest();
        ArrayList<String> moodBooster = getAnalysed.getMoodBooster();

        // Setters
        getAnalysed.setMostArtist(mostArtists);
        getAnalysed.setMostGenre(mostGenre);
        getAnalysed.setMostDance(mostDanceable);
        getAnalysed.setMostPopular(mostPopular);
        getAnalysed.setMostHappy(happiest);
        getAnalysed.setMostSad(saddest);
        getAnalysed.setres(moodBooster);

        return getAnalysed;
    }
}
