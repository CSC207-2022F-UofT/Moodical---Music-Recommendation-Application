package Entities;/* Below is the Question Pool entity object with its constructor.

 */

import java.util.ArrayList;


public class questionPool {
    public static ArrayList<String> lstOfQs = new ArrayList<>();

    public questionPool(Entities.ReadableFile p, Object filepath){

        ArrayList<String> lstOfQs = p.readRows(filepath);
    }

    /**
     * getter
     *
     * @return lstOfQs instance attribute
     */
    public static ArrayList<String> getRandQ(){
        return lstOfQs;
    }

    /**
     * setter (sets the lstOfQs instance attribute to given list of question strings)
     *
     * @param lst
     */
    public static void setRandQ(ArrayList<String> lst){
        lstOfQs = lst;
    }
}