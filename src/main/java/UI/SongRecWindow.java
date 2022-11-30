package UI;

import Entities.Song;
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
    ArrayList<Integer> submittedSliderValues;

    String[] artistImages = new String[] {"Adele", "Ariana Grande", "Beyonce", "Bruno Mars", "Drake",
            "Ed Sheeran", "Eminem", "Jennifer Lopez", "Justin Bieber", "Justin Timberlake", "Katy Perry", "Lady Gaga",
            "Maroon 5", "One Direction", "Pitbull", "Rihanna", "The Black Eyed Peas", " The Chainsmokers",
            "The Weeknd"};

    ArrayList<String> availableArtistImages;

    public SongRecWindow() {
        initializeSongRecWindow();
        submittedSliderValues = new ArrayList<Integer>();
        submittedSliderValues.add(1);
        submittedSliderValues.add(3);
        submittedSliderValues.add(5);
        submittedSliderValues.add(8);
        submittedSliderValues.add(9);
    }

    private void initializeSongRecWindow(){
        SongRecPresenter sPresenter = new SongRecPresenter();
        SongRecResponseModel sResponseModel = new SongRecResponseModel(submittedSliderValues);
        ArrayList<Song> songNameSet; // now have our songs

        sResponseModel = sPresenter.generate(sResponseModel);
        songNameSet = sResponseModel.get5RandSongs();

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
        mainPanel.setLayout(new GridLayout(7, 1));

        // formatting song recs:
        // song names
        song1 = new JLabel(songNameSet.get(0).getSong());
        song2 = new JLabel(songNameSet.get(1).getSong());
        song3 = new JLabel(songNameSet.get(2).getSong());
        song4 = new JLabel(songNameSet.get(3).getSong());
        song5 = new JLabel(songNameSet.get(4).getSong());

        availableArtistImages.addAll(List.of(artistImages)); // for searching purposes

        // song artists pictures
        // song image 1
        if(availableArtistImages.contains(songNameSet.get(0).getArtist())){
            image1.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(0).getArtist() +
                    "jpeg"));
        }
        else {
            image1.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 2
        if(availableArtistImages.contains(songNameSet.get(1).getArtist())){
            image2.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(1).getArtist() +
                    "jpeg"));
        }
        else {
            image2.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 3
        if(availableArtistImages.contains(songNameSet.get(2).getArtist())){
            image3.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(2).getArtist() +
                    "jpeg"));
        }
        else {
            image3.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 4
        if(availableArtistImages.contains(songNameSet.get(3).getArtist())){
            image4.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(3).getArtist() +
                    "jpeg"));
        }
        else {
            image4.setIcon(new ImageIcon("program-images/artist-images/defaultpic.jpg"));
        }

        // song image 5
        if(availableArtistImages.contains(songNameSet.get(4).getArtist())){
            image5.setIcon(new ImageIcon("program-images/artist-images/" + songNameSet.get(4).getArtist() +
                    "jpeg"));
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

    }

    public static void main(String[] args){
        new SongRecWindow();
    }

}
