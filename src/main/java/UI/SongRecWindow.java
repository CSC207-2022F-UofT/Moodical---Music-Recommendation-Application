package UI;

import Entities.Song;
import Entities.SongPool;
import Presenters.QuestionnairePresenter;
import Presenters.SongRecPresenter;
import ResponseModels.QuestionnaireResponseModel;
import ResponseModels.SongRecResponseModel;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SongRecWindow extends JFrame {
    JPanel mainPanel;

    JButton goNextPage;

    JLabel song1, song2, song3, song4, song5;

    JLabel image1, image2, image3, image4, image5;
    double averageHappyScore;

    ArrayList<Song> recommendedSongs;

    String[] artistImages;
    ArrayList<String> availableArtistImages;

    public SongRecWindow(double givenAHappyScore) {
        this.averageHappyScore = givenAHappyScore;
        artistImages = new String[] {"Adele", "Ariana Grande", "Beyonce", "Bruno Mars", "Drake",
                "Ed Sheeran", "Eminem", "Jennifer Lopez", "Justin Bieber", "Justin Timberlake", "Katy Perry",
                "Lady Gaga", "Maroon 5", "One Direction", "Pitbull", "Rihanna", "The Black Eyed Peas",
                "The Chainsmokers", "The Weeknd"};
        availableArtistImages = new ArrayList<String>();
        initializeSongRecWindow();
    }

    private void initializeSongRecWindow(){
        SongPool processingSongPool = new SongPool();
        SongRecPresenter sPresenter = new SongRecPresenter();
        recommendedSongs = new ArrayList<Song>();
        SongRecResponseModel sResponseModel = new SongRecResponseModel(processingSongPool, averageHappyScore,
                recommendedSongs);
        ArrayList<Song> songNameSet; // now have our songs

        sResponseModel = sPresenter.generate(sResponseModel);
        songNameSet = sResponseModel.get5RandSongs();

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
        mainPanel.setLayout(new GridLayout(7, 1));

        // formatting song recs:
        // song names
        song1 = new JLabel(songNameSet.get(0).getSong() + " by. " + songNameSet.get(0).getArtist());
        song2 = new JLabel(songNameSet.get(1).getSong() + " by. " + songNameSet.get(1).getArtist());
        song3 = new JLabel(songNameSet.get(2).getSong() + " by. " + songNameSet.get(2).getArtist());
        song4 = new JLabel(songNameSet.get(3).getSong() + " by. " + songNameSet.get(3).getArtist());
        song5 = new JLabel(songNameSet.get(4).getSong() + " by. " + songNameSet.get(4).getArtist());

        availableArtistImages.addAll(List.of(artistImages)); // for searching purposes

        // song artists pictures
        // song image 1
        image1 = new JLabel();
        image2 = new JLabel();
        image3 = new JLabel();
        image4 = new JLabel();
        image5 = new JLabel();

        if(availableArtistImages.contains(songNameSet.get(0).getArtist())){
            image1.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(0).getArtist() +
                    ".jpeg"));
        }
        else {
            image1.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 2
        if(availableArtistImages.contains(songNameSet.get(1).getArtist())){
            image2.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(1).getArtist() +
                    ".jpeg"));
        }
        else {
            image2.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 3
        if(availableArtistImages.contains(songNameSet.get(2).getArtist())){
            image3.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(2).getArtist() +
                    ".jpeg"));
        }
        else {
            image3.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 4
        if(availableArtistImages.contains(songNameSet.get(3).getArtist())){
            image4.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(3).getArtist() +
                    ".jpeg"));
        }
        else {
            image4.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 5
        if(availableArtistImages.contains(songNameSet.get(4).getArtist())){
            image5.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(4).getArtist() +
                    ".jpeg"));
        }
        else {
            image5.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }


        // initializing frame w/ panel
        add(mainPanel, BorderLayout.CENTER);
        setTitle("Song Recommendation!");
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false); // needs to be because we want only visible AFTER user presses submit results button

        // adding songs and images to panel
        mainPanel.add(image1);
        mainPanel.add(song1);
        mainPanel.add(image2);
        mainPanel.add(song2);
        mainPanel.add(image3);
        mainPanel.add(song3);
        mainPanel.add(image4);
        mainPanel.add(song4);
        mainPanel.add(image5);
        mainPanel.add(song5);

    }
}
