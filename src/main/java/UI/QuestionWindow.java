package UI;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JButton;


public class QuestionWindow extends JFrame{
    private JLabel questionnaire_explaination;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JSlider slider4;
    private JSlider slider5;


    public QuestionWindow() {
        // setContentPane(qPanel);

        // initializing frame
        setTitle("Questionnaire Time!");
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args){
        QuestionWindow qWindow = new QuestionWindow();
    }
}

