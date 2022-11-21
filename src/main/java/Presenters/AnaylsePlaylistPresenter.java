package Presenters;

import ResponseModels.AnalysePlaylistResponseModel;
import Boundaries.AnalysePlaylistOutputBoundary;

import java.util.ArrayList;

public abstract class AnaylsePlaylistPresenter implements AnalysePlaylistOutputBoundary {
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
        getAnalysed.setAverageBmp(averageBmp);
        getAnalysed.setMostDance(mostDanceable);
        getAnalysed.setMostPopular(mostPopular);
        getAnalysed.setMostHappy(happiest);
        getAnalysed.setMostSad(saddest);
        getAnalysed.setres(moodBooster);

        return getAnalysed;

    }
}
