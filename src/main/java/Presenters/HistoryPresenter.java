package Presenters;

import Processors.HistoryProcessor;
import UI.HistoryWindow;

import java.util.ArrayList;

public class HistoryPresenter {
    public HistoryPresenter(){
        String [][] tabledata = HistoryProcessor.toArray(HistoryProcessor.userAccount);
        HistoryWindow.Hwindow(tabledata);
    }

}
