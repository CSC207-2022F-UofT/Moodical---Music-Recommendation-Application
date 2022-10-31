import java.util.ArrayList;

public class History extends Reccommendable {
    public ArrayList previous_songs;

    public History(){
    this.previous_songs = new ArrayList<String>();
    }
    public String[] generateRec(ArrayList<String> favourites){
        ArrayList<String> new_playlist = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            int index = (int) ((Math.random() * ((favourites.size()-1)));
            String song = favourites.get(index);
            if (!(new_playlist.contains(song))){
                new_playlist.add(song);
            }
        }
    }
}
