package Boundaries;
import ResponseModels.UserAccountResponseModel;
import RequestModels.UserAccountRequestModel;

public interface InputBoundary {
    UserAccountResponseModel create(UserAccountRequestModel requestModel);
}
