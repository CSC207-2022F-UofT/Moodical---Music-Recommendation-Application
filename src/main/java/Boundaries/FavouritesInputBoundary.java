package Boundaries;
/**
 * Interface implemented by the UseCaseInteractor FavouritesProcessor, includes the addSong function
 *
 */

public interface FavouritesInputBoundary {
    //add song to favourites

    /**
     * @param songName
     */
    void addSong(String songName);

}
