package entitiestests;

import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AccountEntitiesTest {
    /**
     * This test checks if the username, password, history and favourites match the
     * account entity methods which are getter methods.
     */
    ArrayList<ArrayList<Song>> samplePreviousSongs;
    ArrayList<String> favourites;
    History sampleHistory;
    Favourites sampleFavourites;
    Account sampleAccount;

    @BeforeEach
    void createExampleData() {
        samplePreviousSongs = new ArrayList<ArrayList<Song>>();
        favourites = new ArrayList<String>();
        sampleHistory = new History(samplePreviousSongs);
        sampleFavourites = new Favourites(favourites);
        sampleAccount = new Account("myUsername", "myPassword", sampleHistory, sampleFavourites);
    }

    @Test
    public void getUsernameTest() {
        assertEquals(sampleAccount.getUsername(), "myUsername");
    }

    @Test
    public void getPasswordTest() {
        assertEquals(sampleAccount.getPassword(), "myPassword");
    }

    @Test
    public void getUserHistoryTest() {
        assertEquals(sampleAccount.getUserHistory(), sampleHistory);
    }

    @Test
    public void getUserFavouritesTest() {
        assertEquals(sampleAccount.getUserFavourites(), sampleFavourites);
    }

    @Test
    public void changeUsernameTest() {
        String newUsername = "newUsername";
        sampleAccount.changeUsername(newUsername);
        assertEquals(sampleAccount.getUsername(), newUsername);
    }

    @Test
    public void changePasswordTest() {
        String newPassword = "newPassword";
        sampleAccount.changePassword(newPassword);
        assertEquals(sampleAccount.getPassword(), newPassword);
    }
}
