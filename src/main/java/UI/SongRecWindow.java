package UI;

import Presenters.QuestionnairePresenter;
import ResponseModels.QuestionnaireResponseModel;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongRecWindow extends JFrame {
    JPanel mainPanel;

    public SongRecWindow() {

        initializeSongRecWindow();
    }

    private void initializeSongRecWindow(){
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
        mainPanel.setLayout(new GridLayout(7, 1));

        // initializing frame w/ panel
        add(mainPanel, BorderLayout.CENTER);
        setTitle("Song Recommendation!");
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false); // needs to be because we want only visible AFTER user presses submit results button

    }

}
