package main.java.Entities;
import java.util.ArrayList;

public interface Recommendable {
    /**
     * Perform the specific recommendation algorithm
     **/
     ArrayList<String> recommend();

}
