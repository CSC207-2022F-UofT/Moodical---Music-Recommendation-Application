package Processors;

import Boundaries.SongRecInputBoundary;
import Boundaries.SongRecOutputBoundary;
import Entities.Song;
import Entities.SongPool;
import Presenters.SongRecPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SongAnalysisProcessing implements SongRecInputBoundary {

    SongPool songsList;
    SongRecOutputBoundary presenter;

    public SongAnalysisProcessing(SongRecOutputBoundary songRecPresenter, SongPool songList){
        this.presenter = songRecPresenter;
        this.songsList = songList;
    }

    public Song getSong(double averageHappyScore){
        // 'verysad', 'sad', 'happy', 'veryhappy' for type
        ArrayList<Song> copySongList = (ArrayList<Song>) this.songsList.getSongList().clone();
        Collections.shuffle(copySongList); // randomizes
        Song returnSong = copySongList.get(0);

        String type;

        if (0 <= averageHappyScore && averageHappyScore < 3) {
            type = "verysad";
        } else if (4 <= averageHappyScore && averageHappyScore < 6) {
            type = "sad";
        } else if (7 <= averageHappyScore && averageHappyScore < 9) {
            type = "happy";
        } else {
            type = "veryhappy";
        }


        for (int i = 0; i < copySongList.size(); i++)
        {
            Song currentSong = copySongList.get(i);

            if(isDesiredScore(currentSong, type)){
                return currentSong;
            }
        }
        return returnSong;
    }

    private boolean isDesiredScore(Song song, String type){
        if (80 <= getSongHappyScore(song) && Objects.equals(type, "veryhappy")){
            return true;
        }
        else if (50 <= getSongHappyScore(song) && getSongHappyScore(song) < 80 && Objects.equals(type, "happy")){
            return true;
        }
        else if (30 <= getSongHappyScore(song) && getSongHappyScore(song) < 50 && Objects.equals(type, "sad")){
            return true;
        }
        else if (getSongHappyScore(song) < 30 && Objects.equals(type, "verysad")){
            return true;
        }
        else{
            return false;
        }
    }
    private double getSongHappyScore(Song songFromPool){
        int a1 = Integer.parseInt(songFromPool.danceability);
        int a2 = Integer.parseInt(songFromPool.energy);
        int a3 = Integer.parseInt(songFromPool.valence);

        return (a1 + a2 + a3) / 3;
    }

    // only used method, above are helper functions and SHOULD NOT be used outside this class
    // (getSong ok for testing purposes)
    @Override
    public void calculate5Songs(double averageHappyScore) {
        ArrayList<Song> returnList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            returnList.add(getSong(averageHappyScore));
        }

        this.presenter.set5RecSongs(returnList); // want to pass this into output boundary (presenter)
    }
}
