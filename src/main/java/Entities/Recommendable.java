package Entities;
import java.util.ArrayList;

public interface Recommendable {
    /**
     * Perform the specific recommendation algorithm
     **/
     ArrayList<Song> recommend(History songs);

}
