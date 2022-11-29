package Entities;/* Below is the Question Pool entity object with its constructor.

 */

import java.util.ArrayList;


public class questionPool {
    public static ArrayList<String> lstOfQs = new ArrayList<>();

    public questionPool(Entities.ReadableFile p, Object filepath){

        ArrayList<String> lstOfQs = p.readRows(filepath);
    }
    public static ArrayList<String> getRandQ(){
        return lstOfQs;
    }
    public static void setRandQ(ArrayList<String> lst){
        lstOfQs = lst;
    }


}


/*
This class only consists of a list of strings.
We will store and save questions from a csv file using interface which is another doc
 */