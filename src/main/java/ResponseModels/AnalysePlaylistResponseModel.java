package ResponseModels;

import java.util.ArrayList;

import Processors.AnalysePlaylistProcessing;

public class AnalysePlaylistResponseModel {

    ArrayList<String> allArtists = AnalysePlaylistProcessing.getMostArtist();
    ArrayList<String> allGenres = AnalysePlaylistProcessing.getMostArtist();
    ArrayList<String> averageBmp = AnalysePlaylistProcessing.getAverageBmp();
    ArrayList<String> mostDance = AnalysePlaylistProcessing.getMostDanceable();
    ArrayList<String> mostPopular = AnalysePlaylistProcessing.getMostPopular();
    ArrayList<String> mostHappy = AnalysePlaylistProcessing.getHappiest();
    ArrayList<String> mostSad = AnalysePlaylistProcessing.getSaddest();
    ArrayList<String> res = AnalysePlaylistProcessing.getMoodBooster();

    public ArrayList<String> getMostArtist(){
        return allArtists;
    }
    public ArrayList<String> getMostGenre(){
        return allGenres;
    }
    public ArrayList<String> getAverageBmp(){
        return averageBmp;
    }
    public ArrayList<String> getMostDanceable(){
        return mostDance;
    }
    public ArrayList<String> getMostPopular(){
        return mostPopular;
    }
    public ArrayList<String> getHappiest(){
        return mostHappy;
    }
    public ArrayList<String> getSaddest(){
        return mostSad;
    }
    public ArrayList<String> getMoodBooster(){
        return res;
    }

    public void setMostArtist(ArrayList<String> artist){
        this.allArtists = artist;
    }
    public void setMostGenre(ArrayList<String> genre){
        this.allGenres = genre;
    }
    public void setAverageBmp(ArrayList<String> bmp){
        this.averageBmp = bmp;
    }
    public void setMostDance(ArrayList<String> dance){
        this.mostDance = dance;
    }
    public void setMostPopular(ArrayList<String> popular){
        this.mostPopular = popular;
    }
    public void setMostHappy(ArrayList<String> happy){
        this.mostHappy = happy;
    }
    public void setMostSad(ArrayList<String> sad){
        this.mostSad = sad;
    }
    public void setres(ArrayList<String> res){
        this.res = res;
    }
}

//    HashMap<String, Integer> allArtists;
//    HashMap<String, Integer> allGenres;
//    double averageBmp;
//    ArrayList<String> mostDance;
//    ArrayList<String> mostPopular;
//    ArrayList<String> mostHappy;
//    ArrayList<String> mostSad;
//    ArrayList<String> res;