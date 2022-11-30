package ResponseModels;

import Entities.ReadableFile;
import Entities.Song;
import Entities.SongPool;
import Processors.CSVFileProcessing;
import Processors.SongAnalysisProcessing;

import java.util.ArrayList;

public class SongRecResponseModel {
    ReadableFile q = new CSVFileProcessing();
    String filepath = "dataset/songs.csv";
    public ArrayList<Song> recommendedSongs;

    public double happyScore;

    public ArrayList<Integer> givenHappyScore = new ArrayList<Integer>();

    public SongPool songPool = new SongPool();

    public SongRecResponseModel(ArrayList<Integer> sliderScores){
        songPool.populateSongPool(q, filepath);
        happyScore = 0;
        givenHappyScore = sliderScores;
        for(int sliderValue : this.givenHappyScore){
            happyScore += sliderValue;
        }

        // populate with 5 songs
        for(int i = 0; i < 5; i++){
            recommendedSongs.add(SongAnalysisProcessing.getSong(happyScore, songPool)); // get song gives a random song everytime
        }
    }

    public ArrayList<Song> get5RandSongs(){
        return recommendedSongs;
    }

    public void setRecSongs(ArrayList<Song> recommendedSongs) {
        this.recommendedSongs = recommendedSongs;
    }

    public void setSliderScores(ArrayList<Integer> submittedSliderValues) {
        this.givenHappyScore = submittedSliderValues;
    }
}
