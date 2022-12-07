package UI;

import Entities.History;
import Entities.Song;
import Presenters.HistoryRecPresenter;
import ResponseModels.HistoryResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HistorySongRecWindow extends JFrame{
    public static JFrame j;
    public static JPanel mainPanel;

    public static JLabel song1, song2, song3, song4, song5;

    public static JLabel image1, image2, image3, image4, image5;

    public static String[] artistImages;
    public static ArrayList<String> availableArtistImages;


    public void HistorySongRecWindow1(){

        artistImages = new String[]{"Adele", "Ariana Grande", "Beyonce", "Bruno Mars", "Drake",
                "Ed Sheeran", "Eminem", "Jennifer Lopez", "Justin Bieber", "Justin Timberlake", "Katy Perry",
                "Lady Gaga", "Maroon 5", "One Direction", "Pitbull", "Rihanna", "The Black Eyed Peas",
                "The Chainsmokers", "The Weeknd"};
        availableArtistImages = new ArrayList<String>();
//        initializeHistorySongRecWindow();
//    }
//
//    public void initializeHistorySongRecWindow(){

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.setBackground(Color.getHSBColor(164,219,232));

        // initializing frame w/ panel
        add(mainPanel, BorderLayout.CENTER);
        setTitle("Song Recommendation!");
        setSize(1200, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//       setVisible(true); // needs to be because we want only visible AFTER user presses submit results button

//        HistoryResponseModel response = new HistoryResponseModel();

//        HistoryRecPresenter presenter = new HistoryRecPresenter();
//        ArrayList<Song> songNameSet = response.getRecommendedPlaylist();

        // formatting song recs:
        // song names
//        song1 = new JLabel(songNameSet.get(0).getSong() + " by. " + songNameSet.get(0).getArtist());
//        song2 = new JLabel(songNameSet.get(1).getSong() + " by. " + songNameSet.get(1).getArtist());
//        song3 = new JLabel(songNameSet.get(2).getSong() + " by. " + songNameSet.get(2).getArtist());
//        song4 = new JLabel(songNameSet.get(3).getSong() + " by. " + songNameSet.get(3).getArtist());
//        song5 = new JLabel(songNameSet.get(4).getSong() + " by. " + songNameSet.get(4).getArtist());

        song1 = new JLabel("Bad Romance by Lady Gaga");
        song2 = new JLabel("Just The Way You Are by Bruno Mars");
        song3 = new JLabel("Cooler Than Me by Mike Posner");
        song4 = new JLabel("Teenage Dream by Katy Perry");
        song5 = new JLabel("Sexy Bitch by David Guetta");

//        availableArtistImages.addAll(List.of(artistImages)); // for searching purposes
//
//        // song artists pictures
//        // song image 1
        image1 = new JLabel();
        image1.setBounds(5, 5, 200, 200);
        image1.setHorizontalAlignment(SwingConstants.CENTER);

        image2 = new JLabel();
        image2.setBounds(5, 5, 200, 200);
        image2.setHorizontalAlignment(SwingConstants.CENTER);

        image3 = new JLabel();
        image3.setBounds(5, 5, 200, 200);
        image3.setHorizontalAlignment(SwingConstants.CENTER);

        image4 = new JLabel();
        image4.setBounds(5, 5, 200, 200);
        image4.setHorizontalAlignment(SwingConstants.CENTER);

        image5 = new JLabel();
        image5.setBounds(5, 5, 200, 200);
        image5.setHorizontalAlignment(SwingConstants.CENTER);

//        if (availableArtistImages.contains(songNameSet.get(0).getArtist())) {
//            scaleImage("program-images/artist-images/" + songNameSet.get(0).getArtist() +
//                    ".jpeg", image1);
//        } else {
//            scaleImage("program-images/artist-images/defaultpic.jpg", image1);
//        }
//
//        // song image 2
//        if (availableArtistImages.contains(songNameSet.get(1).getArtist())) {
//            scaleImage("program-images/artist-images/" + songNameSet.get(1).getArtist() +
//                    ".jpeg", image2);
//        } else {
//            scaleImage("program-images/artist-images/defaultpic.jpg", image2);
//        }
//
//        // song image 3
//        if (availableArtistImages.contains(songNameSet.get(2).getArtist())) {
//            scaleImage("program-images/artist-images/" + songNameSet.get(2).getArtist() +
//                    ".jpeg", image3);
//        } else {
//            scaleImage("program-images/artist-images/defaultpic.jpg", image3);
//        }
//
//        // song image 4
//        if (availableArtistImages.contains(songNameSet.get(3).getArtist())) {
//            scaleImage("program-images/artist-images/" + songNameSet.get(3).getArtist() +
//                    ".jpeg", image4);
//        } else {
//            scaleImage("program-images/artist-images/defaultpic.jpg", image4);
//        }
//
//        // song image 5
//        if (availableArtistImages.contains(songNameSet.get(4).getArtist())) {
//            scaleImage("program-images/artist-images/" + songNameSet.get(4).getArtist() +
//                    ".jpeg", image5);
//        } else {
//            scaleImage("program-images/artist-images/defaultpic.jpg", image5);
//        }
        scaleImage("program-images/artist-images/Lady Gaga.jpeg", image1);
        scaleImage("program-images/artist-images/Bruno Mars.jpeg", image2);
        scaleImage("program-images/artist-images/defaultpic.jpg", image3);
        scaleImage("program-images/artist-images/Katy Perry.jpeg", image4);
        scaleImage("program-images/artist-images/defaultpic.jpg", image5);

        // adding songs and images to panel
//        mainPanel.add(image1);

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

//        mainPanel.setVisible(true);

        j = new JFrame();
        j.setBackground(Color.getHSBColor(164,219,232));
        j.setSize(1100,1500);
        j.add(mainPanel);
        j.setVisible(true);

    }

    private void scaleImage(String location, JLabel label) {
        ImageIcon icon = new ImageIcon(location);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }

//    public static void main(String[] args){
//
//        HistorySongRecWindow his = new HistorySongRecWindow();
//        his.HistorySongRecWindow1();
//        //new initializeHistorySongRecWindow();
//    }


}

