package Controllers;

import java.util.ArrayList;
import Processors.AnalysePlaylistProcessing;
import Entities.Account;

public class AnalysePlaylistController{

//
//    AnalysePlaylistProcessing.setAnaylseAccount(Account account);

    public static ArrayList<ArrayList<String>> getAllData(){
        return AnalysePlaylistProcessing.getAllData();
    }



}
