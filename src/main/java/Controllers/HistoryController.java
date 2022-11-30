package Controllers;

import Entities.Account;
import Processors.HistoryProcessor;

public class HistoryController {
    public HistoryController(Account account){
        HistoryProcessor.setAccount(account);
    }

}
