package RequestModels;
import Entities.History;
import Entities.Favourites;
import Entities.Song;
import java.util.ArrayList;

public class UserAccountRequestModel {

    private String username;
    private String password;
    private final History userHistory;
    private final Favourites userFavourites;

    public UserAccountRequestModel(String username, String password, History userHistory, Favourites userFavourites){
        this.username = username;
        this.password = password;
        this.userHistory = userHistory;
        this.userFavourites = userFavourites;
    }
    public static History createEmptyHistoryObject(){
        ArrayList<Song> innerArray = new ArrayList<Song>();
        ArrayList<ArrayList<Song>> outerArray = new ArrayList<ArrayList<Song>>();
        outerArray.add(innerArray);

        return new History(outerArray);
    }

    public static Favourites createEmptyFavouritesObject() {
        ArrayList<String> innerArray = new ArrayList<String>();
        return new Favourites(innerArray);
    }
    public void setOrChangeUsername(String username){
        this.username = username;
    }

    public void setOrChangePassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public History getUserHistory() {
        return userHistory;
    }
    public Favourites getUserFavourites(){
        return userFavourites;
    }

}
