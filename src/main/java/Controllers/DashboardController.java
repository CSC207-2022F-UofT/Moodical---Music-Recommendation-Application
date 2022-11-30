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

// All the controller does for the dashboard is to set the account attribute for the playlist analysis, which we will be
// using the username to get the account information and then passed onto here.

// I am thinking if we can do the same for History and or favourites (Set the attribute here)