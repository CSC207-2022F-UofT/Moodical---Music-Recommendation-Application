package Boundaries;

import ResponseModels.UserAccountResponseModel;
import RequestModels.UserAccountRequestModel;

public interface UserAccountInputBoundary {
    UserAccountResponseModel create(UserAccountRequestModel UserRequestModel);
}
