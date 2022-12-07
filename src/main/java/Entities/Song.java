package Entities;

public class Song {
    public String song;
    public String artist;
    public String genre;
    public String energy;
    public String liveness;
    public String valence;
    public String popularity;
    public String danceability;
    public String bpm;

    public boolean favourite;

    public Song(){
    }
    public Song(String songIn, String artistIn, String genreIn, String energyIn, String livenessIn,
                String valenceIn, String popularityIn, String danceabilityIn, String bpm){
        this.song = songIn;
        this.artist = artistIn;
        this.genre = genreIn;
        this.energy = energyIn;
        this.liveness = livenessIn;
        this.valence = valenceIn;
        this.popularity = popularityIn;
        this.danceability = danceabilityIn;
        this.bpm = bpm;
    }

    /**
     * getter
     *
     * @return song's artist instance attribute
     */
    public String getArtist() {
        return artist;
    }

    /**
     * getter
     *
     * @return song's song (song name) instance attribute
     */
    public String getSong() {
        return song;
    }
}
