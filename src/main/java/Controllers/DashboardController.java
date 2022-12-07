package Controllers;

//import Boundaries.AnalysePlaylistInputBoundary;
import Entities.Account;
import Processors.AnalysePlaylistProcessing;


public class DashboardController {
    /**
     * The dashboard controller is responsible for setting the account that is needed for the
     * analysePlaylist system
     */
    public DashboardController(Account account){

        AnalysePlaylistProcessing.setAccount(account);
    }

}