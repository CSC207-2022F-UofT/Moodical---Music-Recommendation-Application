package Processors;

import Boundaries.HistoryInputBoundary;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;
import RequestModels.UserAccountRequestModel;
import ResponseModels.HistoryResponseModel;

import java.util.ArrayList;

public class HistoryInteractor implements HistoryInputBoundary {
    @Override
    public HistoryResponseModel create(UserAccountRequestModel requestModel) {
        Account account = new Account(requestModel.getUsername(), requestModel.getPassword(),
                new History(new ArrayList<>()), new Favourites(new ArrayList<>()));
        // note that ideally I am able to get a History Object and a Favourites Object created from the request model
        //Also note that while currently empty History would have the playlist generate
        HistoryProcessor.setAccount(account);
        ArrayList<Song> recommended = HistoryProcessor.recommend(HistoryProcessor.userAccount);
        HistoryResponseModel responseModel = new HistoryResponseModel();
        responseModel.setRecommendedPlaylist(recommended);
        return responseModel;
    }
}
