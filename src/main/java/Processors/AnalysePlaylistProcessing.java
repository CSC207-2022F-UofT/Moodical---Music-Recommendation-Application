package Processors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Entities.Account;
import Entities.History;
import Entities.Song;

public class AnalysePlaylistProcessing{

    public static Account account;
    public static History allHistory;
    public static ArrayList<Song> prevRecs;

    public static void setAccount(Account account) {
        AnalysePlaylistProcessing.account = account;
        AnalysePlaylistProcessing.allHistory = account.userHistory;
        HistoryProcessor.setAccount(account);
        AnalysePlaylistProcessing.prevRecs = HistoryProcessor.getAllSongs(account);
    }

    public static ArrayList<String> getMostArtist() {
        /* Return the most commonly appeared artist in the user's history (past recommendations)
          Return multiple artists if there is a tie in the number of occurrences
         */
        HashMap<String, Integer> allArtists = new HashMap<String, Integer>();

        ArrayList<String> resArtists = new ArrayList<String>();

        for (Song song : prevRecs) {

            Integer count = allArtists.get(song.artist);
            if (count == null) {
                allArtists.put(song.artist, 1);
            } else {
                allArtists.put(song.artist, count + 1);
            }
        }

        int max = Collections.max(allArtists.values());

        for (String artist : allArtists.keySet()) {
            if (allArtists.get(artist) == max) {
                resArtists.add(artist);
            }
        }
        return resArtists;
    }

    public static ArrayList<String> getMostGenre(){
        /* Return the most commonly appeared genre in the user's history (past recommendations)
          Return multiple genres if there is a tie between the number of occurrences
         */
        HashMap<String, Integer> allGenres = new HashMap<String, Integer>();

        ArrayList<String> resGenres = new ArrayList<String>();

        for (Song song : prevRecs) {
            Integer count = allGenres.get(song.genre);
            if (count == null) {
                allGenres.put(song.genre, 1);
            } else {
                allGenres.put(song.genre, count + 1);
            }
        }

        Integer max = Collections.max(allGenres.values());

        for (String artist : allGenres.keySet()) {
            if (allGenres.get(artist) == max) {
                resGenres.add(artist);
            }
        }
        return resGenres;

    }

    public static ArrayList<String> getAverageBmp() {
        /* Return the average bmp of all the songs in the user's history (past recommendations)
         */
        ArrayList<String> bmp =  new ArrayList<String>();

        double sum = 0;

        for (Song song : prevRecs) {
            sum = sum + Double.parseDouble(song.bpm);
        }

        double total = prevRecs.size();
        String result = Double.toString(sum / total);
        bmp.add(result);

        return bmp;
    }

    public static ArrayList<String> getMostDanceable(){
        /* Return the song(s) with the highest danceability score, return multiple if there are ties
         */
        HashMap<String, Integer> allDanceability = new HashMap<String, Integer>();

        ArrayList<String> mostDance= new ArrayList<String>();

        for (Song song : prevRecs) {
            allDanceability.put(song.song, Integer.parseInt(song.danceability));
        }

        int max = Collections.max(allDanceability.values());

        for (String song : allDanceability.keySet()) {
            if (allDanceability.get(song) == max) {
                mostDance.add(song);
            }
        }
        return mostDance;
    }

    public static ArrayList<String> getMostPopular(){
        /* Return the song(s) with the highest popularity score, return multiple if there are ties
         */
        HashMap<String, Integer> allPopularity = new HashMap<String, Integer>();

        ArrayList<String> mostPopular= new ArrayList<String>();

        for (Song song : prevRecs) {
            allPopularity.put(song.song, Integer.parseInt(song.popularity));
        }

        int max = Collections.max(allPopularity.values());

        for (String song : allPopularity.keySet()) {
            if (allPopularity.get(song) == max) {
                mostPopular.add(song);
            }
        }
        return mostPopular;
    }
    public static ArrayList<String> getHappiest(){
        /* Return the song(s) with the highest valence score, return multiple if there are ties
         */
        HashMap<String, Integer> allValence = new HashMap<String, Integer>();

        ArrayList<String> mostHappy= new ArrayList<String>();

        for (Song song : prevRecs) {
            allValence.put(song.song, Integer.parseInt(song.valence));
        }

        int max = Collections.max(allValence.values());

        for (String song : allValence.keySet()) {
            if (allValence.get(song) == max) {
                mostHappy.add(song);
            }
        }
        return mostHappy;
    }

    public static ArrayList<String> getSaddest(){
        /* Return the song(s) with the lowest valence score, return multiple if there are ties
         */
        HashMap<String, Integer> allValence = new HashMap<String, Integer>();

        ArrayList<String> mostSad = new ArrayList<String>();

        for (Song song : prevRecs) {
            allValence.put(song.song, Integer.parseInt(song.valence));
        }

        int min = Collections.min(allValence.values());

        for (String song : allValence.keySet()) {
            if (allValence.get(song) == min) { mostSad.add(song);
            }
        }
        return mostSad;
    }

    public static ArrayList<String> getMoodBooster(){
        /* Return the song(s) with the highest score of liveness and energy, return multiple if there are ties
         */
        HashMap<String, Integer> allScores = new HashMap<String, Integer>();

        ArrayList<String> res = new ArrayList<String>();

        for (Song song : prevRecs) {
            allScores.put(song.song, Integer.parseInt(song.liveness) + Integer.parseInt(song.energy));
        }
        int max = Collections.max(allScores.values());

        for (String song : allScores.keySet()) {
            if (allScores.get(song) == max) {
                res.add(song);
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<String>> getAllData(){
        ArrayList<ArrayList<String>> allData = new ArrayList<>();

        allData.add(getMostArtist());
        allData.add(getMostGenre());
        allData.add(getAverageBmp());
        allData.add(getMostDanceable());
        allData.add(getMostPopular());
        allData.add(getHappiest());
        allData.add(getSaddest());
        allData.add(getMoodBooster());

        return allData;
    }
}


