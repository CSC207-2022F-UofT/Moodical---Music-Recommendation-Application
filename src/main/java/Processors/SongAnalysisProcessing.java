package Processors;

import Entities.Song;
import Entities.SongPool;

import java.util.ArrayList;
import java.util.Objects;

public class SongAnalysisProcessing {
    public Song getSong(double averageHappyScore, SongPool songs){
        // 'verysad', 'sad', 'happy', 'veryhappy' for type
        ArrayList<Song> songList = songs.getSongList();
        Song returnSong = songList.get(0);

        String type;

        if (0 <= averageHappyScore &&  averageHappyScore < 3) {
            type = "verysad";
        } else if (4 <= averageHappyScore &&  averageHappyScore < 6) {
            type = "sad";
        } else if (7 <= averageHappyScore &&  averageHappyScore < 9) {
            type = "happy";
        } else {
            type = "veryhappy";
        }

        for (int i = 0; i < songList.size(); i++)
        {
            // generating the index using Math.random()
            int index = (int)(Math.random() * songList.size());

            Song currentSong = songList.get(index);

            if(isDesiredScore(currentSong, type)){
                return currentSong;
            }
        }
        return returnSong;
    }

    public boolean isDesiredScore(Song song, String type){
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
    public double getSongHappyScore(Song songFromPool){
        int a1 = Integer.parseInt(songFromPool.danceability);
        int a2 = Integer.parseInt(songFromPool.energy);
        int a3 = Integer.parseInt(songFromPool.valence);

        return (a1 + a2 + a3) / 3;
    }
}
