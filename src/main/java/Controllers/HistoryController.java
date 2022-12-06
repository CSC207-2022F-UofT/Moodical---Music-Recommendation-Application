package Controllers;

import Boundaries.HistoryInputBoundary;
import RequestModels.UserAccountRequestModel;
import ResponseModels.HistoryResponseModel;

public class HistoryController {
    private final HistoryInputBoundary historyInput;


    public HistoryController(HistoryInputBoundary historyInput) {
        this.historyInput = historyInput;
    }
    HistoryResponseModel create(UserAccountRequestModel accountRequestModel){
        return historyInput.create(accountRequestModel);
    }
}
