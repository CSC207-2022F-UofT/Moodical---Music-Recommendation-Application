package Controllers;

//import Boundaries.AnalysePlaylistInputBoundary;
import Entities.Account;
import Processors.AnalysePlaylistProcessing;


public class DashboardController {

    public DashboardController(Account account){

        AnalysePlaylistProcessing.setAccount(account);
    }

}