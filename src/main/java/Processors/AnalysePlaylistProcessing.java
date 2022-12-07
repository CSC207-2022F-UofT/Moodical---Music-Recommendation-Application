package Processors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Entities.Account;
import Entities.History;
import Entities.Song;

public class AnalysePlaylistProcessing{

    /** This processing (use case) performs all the calculations needed to display
     * the correct analysis for the main dashboard page
     */

    public static Account account;
    public static History allHistory;
    public static ArrayList<Song> prevRecs;

    /**
     * This method sets the account of the analysePlaylistProcessing and historyProcessor
     */
    public static void setAccount(Account account) {
        AnalysePlaylistProcessing.account = account;
        AnalysePlaylistProcessing.allHistory = account.userHistory;
        HistoryProcessor.setAccount(account);
        AnalysePlaylistProcessing.prevRecs = HistoryProcessor.getAllSongs(account);
    }

    /**
     * Return the most commonly appeared artist in the user's history (past recommendations)
     * Return multiple artists if there is a tie in the number of occurrences
     */

    public static ArrayList<String> getMostArtist() {

        HashMap<String, Integer> allArtists = new HashMap<>();

        ArrayList<String> resArtists = new ArrayList<>();

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

    /**
     *  Return the most commonly appeared genre in the user's history (past recommendations)
     *  Return multiple genres if there is a tie between the number of occurrences
     */

    public static ArrayList<String> getMostGenre(){

        HashMap<String, Integer> allGenres = new HashMap<>();

        ArrayList<String> resGenres = new ArrayList<>();

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

    /**
     * Return the average bmp of all the songs in the user's history (past recommendations)
     */

    public static ArrayList<String> getAverageBmp() {

        ArrayList<String> bmp = new ArrayList<>();

        double sum = 0;

        for (Song song : prevRecs) {
            sum = sum + Double.parseDouble(song.bpm);
        }

        double total = prevRecs.size();
        String result = Double.toString(sum / total);
        bmp.add(result);

        return bmp;
    }

    /**
     * Return the song(s) with the highest danceability score, return multiple if there are ties
     */

    public static ArrayList<String> getMostDanceable(){

        HashMap<String, Integer> allDanceability = new HashMap<>();

        ArrayList<String> mostDance= new ArrayList<>();

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

    /**
     * Return the song(s) with the highest popularity score, return multiple if there are ties
     */

    public static ArrayList<String> getMostPopular(){

        HashMap<String, Integer> allPopularity = new HashMap<>();

        ArrayList<String> mostPopular= new ArrayList<>();

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

    /**
     * Return the song(s) with the highest valence score, return multiple if there are ties
     */

    public static ArrayList<String> getHappiest(){

        HashMap<String, Integer> allValence = new HashMap<>();

        ArrayList<String> mostHappy= new ArrayList<>();

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

    /**
     * Return the song(s) with the lowest valence score, return multiple if there are ties
     */
    public static ArrayList<String> getSaddest(){

        HashMap<String, Integer> allValence = new HashMap<>();

        ArrayList<String> mostSad = new ArrayList<>();

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

    /**
     * Return the song(s) with the highest score of liveliness and energy, return multiple if there are ties
     */

    public static ArrayList<String> getMoodBooster(){

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

    /**
     * This returns all the data analysed combined, and the returned data is used by the dashboard
     */

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


