package RequestModels;
import Entities.History;
import Entities.Favourites;
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

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public String getUserHistory() {
        return this.userHistory.toString();
    }
    public String getUserFavourites(){
        return this.userFavourites.toString();
    }

}
