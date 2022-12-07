package Presenters;

import Boundaries.FavouritesOutputBoundary;
import UI.FavouritesSuccessWindow;

public class FavouritesPresenter implements FavouritesOutputBoundary {

    @Override
    public void showSuccessScreen() {
        new FavouritesSuccessWindow();
    }
}
