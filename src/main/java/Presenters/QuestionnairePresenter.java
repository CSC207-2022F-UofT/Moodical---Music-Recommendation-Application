package Presenters;

import Boundaries.QuestionnaireOutputBoundary; //this is the alias presenter from gries's lec
import Models.QuestionnaireResponseModel;
import Processors.QuestionnaireProcessing;

import java.util.ArrayList;

public class QuestionnairePresenter implements QuestionnaireOutputBoundary{
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
