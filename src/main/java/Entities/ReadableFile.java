package Entities;

import java.util.ArrayList;

public interface ReadableFile {
    /**
     * Read the file type specified
     **/

     ArrayList<String> readRows(String filePath); // Returns an array list containing String for each line of file (i.e. csv, etc.)
}
