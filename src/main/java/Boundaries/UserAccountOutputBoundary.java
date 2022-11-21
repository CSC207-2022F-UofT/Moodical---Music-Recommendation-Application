package Boundaries;

import ResponseModels.UserAccountResponseModel;

public interface UserAccountOutputBoundary {
    UserAccountResponseModel prepareSuccessView(UserAccountResponseModel account);
    UserAccountResponseModel prepareFailView(String error);
}