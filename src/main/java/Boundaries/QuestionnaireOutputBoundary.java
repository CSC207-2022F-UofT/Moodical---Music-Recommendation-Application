package Boundaries;

import ResponseModels.QuestionnaireResponseModel;

public interface QuestionnaireOutputBoundary {

    QuestionnaireResponseModel generate(QuestionnaireResponseModel response);

}
