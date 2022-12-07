package Controllers;


import Boundaries.FavouritesInputBoundary;
import Processors.FavouritesProcessor;

public class FavouritesController {
    public FavouritesInputBoundary processor;

    public FavouritesController(FavouritesInputBoundary processor){
        this.processor = processor;
    }

    public void generate(String song){
        processor.addSong(song);
    }
}