package Controllers;

//import Boundaries.AnalysePlaylistInputBoundary;
import Entities.Account;
import Processors.AnalysePlaylistProcessing;
import ResponseModels.AnalysePlaylistResponseModel;
import Processors.HistoryProcessor;


public class DashboardController {

    public DashboardController(Account account){
        AnalysePlaylistProcessing.setAccount(account);
    }

}

// When an account is created, we need to also give the user input to the history class/
// their controllers, playlist and anything that depends on account