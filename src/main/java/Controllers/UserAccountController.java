package Controllers;

import RequestModels.UserAccountRequestModel;

import java.io.IOException;

public class UserAccountController {

    public static void registerAccount(UserAccountRequestModel requestModel){
        Processors.UserAccountProcessing.writeAccountToCSV(requestModel.getUsername(),
                requestModel.getPassword(), requestModel.getUserHistory(),
                requestModel.getUserFavourites());
    }

    public static Boolean returnUserExistence(UserAccountRequestModel requestModel) throws IOException {
        return Processors.UserAccountProcessing.returnUserExists(requestModel.getUsername());
    }
}
