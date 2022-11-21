package Boundaries;


import ResponseModels.QuestionnaireResponseModel;
import ResponseModels.AnalysePlaylistResponseModel;

public interface OutputBoundary {

    AnalysePlaylistResponseModel analysePlaylist(AnalysePlaylistResponseModel getAnalysed);
    QuestionnaireResponseModel generateQ(QuestionnaireResponseModel generate);


}
