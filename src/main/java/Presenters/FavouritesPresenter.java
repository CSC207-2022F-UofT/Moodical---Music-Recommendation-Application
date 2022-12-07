package Presenters;

import Boundaries.FavouritesOutputBoundary;
import UI.FavouritesSuccessWindow;

/**
 * Clean Arch Level Presenter
 * implements FavouritesOutputBoundary
 *
 */

public class FavouritesPresenter implements FavouritesOutputBoundary {


    @Override
    /**
     *
     * calls the UI method to show the successWindow, this is called by the UseCase function if the function successful runs
     *
     */
    public void showSuccessScreen() {
        new FavouritesSuccessWindow();
    }
}
