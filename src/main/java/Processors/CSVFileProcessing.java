package Processors;

import Entities.ReadableFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileProcessing implements ReadableFile {

    /**
     *
     *
     * @param filePath that represents the directory/path of the dataset calculated on
     * @return an array list of strings where each element/string represents a line of data in the data set (CSV)
     */
    @Override
    public ArrayList<String> readRows(Object filePath) {
        String line = "";
        ArrayList<String> rowsRead = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader((String) filePath));

            while((line = br.readLine()) != null) {
                rowsRead.add(line);
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        return rowsRead;
    }
}

// Are you creating song objects from the things you are reading from the file?
