package Presenters;

import Processors.HistoryProcessor;

import java.util.ArrayList;

public class HistoryPresenter {
    public HistoryPresenter(){
        ArrayList<String> tabledata = HistoryProcessor.get_song_strings(HistoryProcessor.userAccount);
    }
}
