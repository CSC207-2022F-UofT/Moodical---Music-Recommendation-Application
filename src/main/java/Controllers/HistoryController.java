package Controllers;

import Entities.Account;
import Processors.HistoryProcessor;

public class HistoryController {
    //by my understanding responds to buttons being pressed
    //needs to be called by whichever class generates the questionnaire
    public HistoryController(Account account){
        HistoryProcessor.setAccount(account);
    }

}
