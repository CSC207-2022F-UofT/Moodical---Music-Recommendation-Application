package Presenters;

import Boundaries.QuestionnaireOutputBoundary;
import ResponseModels.QuestionnaireResponseModel;
import java.util.ArrayList;

public class QuestionnairePresenter implements QuestionnaireOutputBoundary {
    /**
     * Obtains the questions from output boundary of questionnaire
     */

    @Override
    public QuestionnaireResponseModel generate(QuestionnaireResponseModel response) {
        ArrayList<String> questions = response.getRandQs();
        response.setRandQs(questions);
        return response;
    }
}
