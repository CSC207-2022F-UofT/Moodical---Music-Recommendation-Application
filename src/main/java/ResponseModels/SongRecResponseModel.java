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

    public SongPool songPool;


    public SongRecResponseModel(SongPool sPool, double averageHappyScore, ArrayList<Song> rSongs){
        songPool = sPool;
        songPool.populateSongPool(q, filepath);
        recommendedSongs = rSongs;

        // populate with 5 songs
        for(int i = 0; i < 5; i++){
            recommendedSongs.add(SongAnalysisProcessing.getSong(averageHappyScore, songPool)); // get song gives a random song everytime
        }
    }

    public ArrayList<Song> get5RandSongs(){
        return recommendedSongs;
    }

    public void setRecSongs(ArrayList<Song> recommendedSongs) {
        this.recommendedSongs = recommendedSongs;
    }

}
