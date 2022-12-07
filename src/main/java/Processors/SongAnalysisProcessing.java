package Processors;

import Boundaries.SongRecInputBoundary;
import Boundaries.SongRecOutputBoundary;
import Entities.Song;
import Entities.SongPool;

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

    /**
     * given average happy score, will parse through song pool instance to pick out a song that matches
     * corresponding happy score (i.e. low happy score of 3, this method will return 'sad' song type)
     *
     * @param averageHappyScore
     * @return song object calculated from given average happy score
     */
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

    /**
     * given a song object and string type, calculates if the song matches the happiness level of the type
     *
     * @param song
     * @param type
     * @return returns boolean true or false based on if given song matches the song type of string type
     */
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

    /**
     * helper function for getSong that gets the happy score of a given song
     *
     * @param songFromPool
     * @return happy score of given song object from song pool
     */
    private double getSongHappyScore(Song songFromPool){
        int a1 = Integer.parseInt(songFromPool.danceability);
        int a2 = Integer.parseInt(songFromPool.energy);
        int a3 = Integer.parseInt(songFromPool.valence);

        return (a1 + a2 + a3) / 3;
    }

    // only used method, above are helper functions and SHOULD NOT be used outside this class
    // (getSong ok for testing purposes)

    /**
     * (method for clean architecture, called by the Controller to be used in UI level)
     * calculates given happy score from userinput and calls presenter output boundary methods to 'pass up'
     * list of songs to UI level
     *
     * @param averageHappyScore
     */
    @Override
    public void calculate5Songs(double averageHappyScore) {
        ArrayList<Song> returnList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            returnList.add(getSong(averageHappyScore));
        }

        this.presenter.set5RecSongs(returnList); // want to pass this into output boundary (presenter)
    }
}
