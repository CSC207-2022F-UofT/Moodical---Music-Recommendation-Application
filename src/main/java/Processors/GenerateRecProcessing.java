package Processors;

import entities.Account;
import entities.Recommendable;
import entities.Song;

import java.util.ArrayList;

/**
 * Returns recommendation based on user input from questionnaire
 *
 */
public class GenerateRecProcessing implements Recommendable {
    @Override
    public ArrayList<Song> recommend(Object songs, Account userAccount) {
        return null;
    }
}
