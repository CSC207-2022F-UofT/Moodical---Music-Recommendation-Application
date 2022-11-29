package Presenters;

import Processors.AnalysePlaylistProcessing;
import UI.Dashboard;

import java.util.ArrayList;

public class DashboardPresenter {

    public DashboardPresenter() {
        ArrayList<ArrayList<String>> tableData = AnalysePlaylistProcessing.getAllData();
        // Dashboard.main(tableData);
    }

}
