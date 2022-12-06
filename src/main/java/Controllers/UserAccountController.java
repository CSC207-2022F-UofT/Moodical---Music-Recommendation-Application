package Controllers;

import Processors.UserAccountProcessing;
import RequestModels.UserAccountRequestModel;

import java.io.IOException;

public class UserAccountController {

    public static void registerAccount(UserAccountRequestModel requestModel){
        UserAccountProcessing.writeAccountToCSV(requestModel.getUsername(),
                requestModel.getPassword(), requestModel.getUserHistory(),
                requestModel.getUserFavourites());
    }

    public static Boolean returnUserExistence(UserAccountRequestModel requestModel) throws IOException {
        return UserAccountProcessing.returnUserExists(requestModel.getUsername());
    }
}
