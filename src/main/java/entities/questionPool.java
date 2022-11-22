package entities;/* Below is the Question Pool entity object with its constructor.

 */

import java.util.ArrayList;


public class questionPool{
    public ArrayList<String> lstOfQs = new ArrayList<>();

    public questionPool(ReadableFile p, Object filepath){
        this.lstOfQs = p.readRows(filepath);
    }

}


/*
This class only consists of a list of strings.
We will store and save questions from a csv file using interface which is another doc
 */