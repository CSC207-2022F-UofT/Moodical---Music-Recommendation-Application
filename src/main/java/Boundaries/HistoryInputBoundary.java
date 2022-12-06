package Boundaries;

import RequestModels.UserAccountRequestModel;
import ResponseModels.HistoryResponseModel;

public interface HistoryInputBoundary {

    public HistoryResponseModel create(UserAccountRequestModel requestModel);
}
