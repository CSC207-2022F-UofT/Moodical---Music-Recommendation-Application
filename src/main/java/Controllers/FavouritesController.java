package Controllers;


import Boundaries.FavouritesInputBoundary;

/**
 * Clean Arch Level: Controllers
 * takes an input boundary as instance attribute
 */

public class FavouritesController {
    public FavouritesInputBoundary processor;

    /**
     * @param processor
     *  constructs controller
     */

    public FavouritesController(FavouritesInputBoundary processor){
        this.processor = processor;
    }

    /**
     * @param song
     * calls the processor's method for the useCase addSong
     */
    public void generate(String song){
        processor.addSong(song);
    }
}