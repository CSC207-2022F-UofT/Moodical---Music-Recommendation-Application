package Boundaries;


import ResponseModels.AnalysePlaylistResponseModel;
import ResponseModels.UserAccountResponseModel;
// import RequestModels.UserAccountRequestModel;

public interface OutputBoundary {

    AnalysePlaylistResponseModel analysePlaylist(AnalysePlaylistResponseModel getAnalysed);
    // UserAccountResponseModel prepareSuccessView(UserAccountResponseModel account);
    // UserAccountRequestModel prepareFailView(String error);
}
