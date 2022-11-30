package Boundaries;

import ResponseModels.QuestionnaireResponseModel;
import ResponseModels.SongRecResponseModel;

public interface SongRecOutputBoundary {

    SongRecResponseModel generate(SongRecResponseModel response);

}
