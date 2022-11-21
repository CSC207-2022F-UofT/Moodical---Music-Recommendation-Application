package Presenters;

import Boundaries.AnalysePlaylistOutputBoundary;
import ResponseModels.QuestionnaireResponseModel;

import java.util.ArrayList;

public abstract class QuestionnairePresenter implements AnalysePlaylistOutputBoundary {

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
