package Presenters;

import Boundaries.OutputBoundary;
import ResponseModels.AnalysePlaylistResponseModel;
import ResponseModels.QuestionnaireResponseModel;

import java.io.IOException;
import java.util.ArrayList;

public abstract class QuestionnairePresenter implements OutputBoundary {

    /**
     * Obtains the questions from output boundary of questionnaire
     */

    @Override
    public QuestionnaireResponseModel generateQ(QuestionnaireResponseModel response) {
        ArrayList<String> questions = response.getRandQs();
        response.setRandQs(questions);
        return response;
    }
}
