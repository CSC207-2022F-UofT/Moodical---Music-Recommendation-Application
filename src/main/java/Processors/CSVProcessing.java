package Processors;

import Entities.ReadableFile;
import Entities.Song;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVProcessing implements ReadableFile {

    /**
     *
     * @param
     * @return Song object based on the read line
     */
    @Override
    public Song readLine(String[] values) {
        Song newSong = new Song();

        newSong.song = values[0];
        newSong.artist = values[1];

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
                // songs.add()
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
