package Entities;
import Processors.CSVFileProcessing;

import java.util.ArrayList;

public class SongPool {
    public ArrayList<Song> songs;

    public SongPool() {
        this.songs = new ArrayList<>();
    }

    public void populateSongPool(ReadableFile songFile) {
        ArrayList<String> songsReadFromFile = songFile.readFile(); //want readFile to return a list of Songs, we don't care how
        for (String readLine : songsReadFromFile) {
            String[] values = readLine.split(",");
            this.songs.add(CSVFileProcessing.readLine(values));
        }
    }

}
