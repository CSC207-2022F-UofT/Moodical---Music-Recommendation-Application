package Entities;

import java.util.ArrayList;

public interface ReadableFile {
    /**
     * Read the file type specified
     **/

     ArrayList<String> readFile(); // Returns an array list containing String for each line of file (i.e. csv, etc.)
}
