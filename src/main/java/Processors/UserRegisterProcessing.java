package Processors;
import Entities.Account;
import Entities.Favourites;
import Entities.History;

public class UserRegisterProcessing extends Account {
    public UserRegisterProcessing(String username, String password, History previous_songs, Favourites favourites) {
        super(username, password, previous_songs, favourites);
    }

    public void createAccount(String username, String password) {
        this.username = username;
        this.password = password;
        AllUsers.put(username, password);
    }

    public boolean checkUserExists(String username, String password) {
        return AllUsers.containsKey(username);
    }

    public boolean createNewAccount(String username, String password) {
        if (!(AllUsers.containsKey(username))) {
            createAccount(username, password);
            return true;
        }
        return false;
    }

}
