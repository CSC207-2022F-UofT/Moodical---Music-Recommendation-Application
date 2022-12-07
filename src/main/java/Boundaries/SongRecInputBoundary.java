package Boundaries;

public interface SongRecInputBoundary {

    /**
     * method to talk to use case interactor to generate 5 songs
     *
     * @param averageHappyScore
     */
    void calculate5Songs(double averageHappyScore);
}
