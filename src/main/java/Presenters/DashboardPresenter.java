package Presenters;

import Processors.AnalysePlaylistProcessing;
import UI.Dashboard;

import java.util.ArrayList;

public class DashboardPresenter {

    public DashboardPresenter() {


        ArrayList<ArrayList<String>> tableData = AnalysePlaylistProcessing.getAllData();
        //// Dashboard.main(tableData); // I will be calling the dashboard UI from here

        // Note: I am thinking if we should also have the history and favourites presenter stuff coded here since
        // according to the flow it will be accessed from dashboard.

    }
}