package Entities;/* Below is the Question Pool entity object with its constructor.

 */

import java.util.ArrayList;
import java.util.List;



public class questionPool{
    ArrayList<String> lstOfQs = new ArrayList<>();

    public ArrayList<String> questionPool(){
        return this.lstOfQs;
    }
}


/*
This class only consists of a list of strings.
We will store and save questions from a csv file using interface which is another doc.
There will be 3 csv files - standard questions, positive questions, negative questions
 */