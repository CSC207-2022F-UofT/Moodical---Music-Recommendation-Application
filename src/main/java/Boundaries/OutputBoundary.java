package Boundaries;


import ResponseModels.QuestionnaireResponseModel;
import ResponseModels.AnalysePlaylistResponseModel;
// import ResponseModels.UserAccountResponseModel;
// import RequestModels.UserAccountRequestModel;

public interface OutputBoundary {
   // AnalysePlaylistResponseModel analysePlaylist(AnalysePlaylistResponseModel getAnalysed);
    QuestionnaireResponseModel generateQ(QuestionnaireResponseModel generate);
    // UserAccountResponseModel prepareSuccessView(UserAccountResponseModel account);
    //UserAccountRequestModel prepareFailView(String error);
}
