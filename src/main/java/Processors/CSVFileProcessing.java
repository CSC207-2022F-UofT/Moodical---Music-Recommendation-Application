package Processors;

import Entities.CSVFile;
import Entities.Song;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileProcessing {

    int bruh;
    /**
     *
     * @param
     * @return Song object based on the read line
     */

    public static Song readLine(String[] values) {
        Song newSong = new Song();

        newSong.song = values[0];
        newSong.artist = values[1];
        newSong.genre = values[2];
        newSong.energy = values[5];
        newSong.liveness = values[8];
        newSong.valence = values[9];
        newSong.popularity = values[13];
        newSong.danceability = values[6];
        newSong.bpm = values[4];

        return newSong;
    }


    public static void main(String[] args) {
        String path = "/Users/alex/Desktop/SacramentocrimeJanuary2006.csv";
        String line = "";
        ArrayList<Song> songs = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                songs.add(readLine(values));
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

}
