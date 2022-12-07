package RequestModels;

import Entities.Account;
import Processors.FavouritesProcessor;

public class FavouritesRequestModel {
    private String song;
    private FavouritesProcessor processor;

    public void setSong(String song) {
        this.song = song;
    }
    // takes the user input which is set as the attribute
    // calls the addto function from the processor
    public void addTo() {
        processor.addTo(song, processor.userAccount);
    }
}
