package UI;

import Presenters.QuestionnairePresenter;
import ResponseModels.QuestionnaireResponseModel;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class QuestionWindow extends JFrame implements ActionListener{
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JSlider slider4;
    private JSlider slider5;

    private JPanel messagePanel;
    private JPanel mainPanel;

    private JLabel q1;
    private JLabel q2;
    private JLabel q3;
    private JLabel q4;
    private JLabel q5;

    // CREATE INSTANCE OF RECOMMENDATION TO BUILD REC ON AND THEN SHOW WHEN RESULTS SUBMITTED (i.e. being built
    // in the background constantly while user adjusting slides)
    SongRecWindow songRecWindow;

    // the slider values
    private ArrayList<Integer> sliderValues = new ArrayList<Integer>();


    public QuestionWindow() {

        initializeQuestionnaireWindow();
    }

    private void initializeQuestionnaireWindow(){
        QuestionnairePresenter qPresenter = new QuestionnairePresenter();
        QuestionnaireResponseModel qResponseModel = new QuestionnaireResponseModel();
        ArrayList<String> questionSet;

        // Text for user Panel
        messagePanel = new JPanel();
        messagePanel.setBorder(BorderFactory.createEmptyBorder(30, 70, 30, 10));
        messagePanel.setLayout(new GridLayout());

        // Interaction Panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
        mainPanel.setLayout(new GridLayout(7, 1));

        JButton submitAnswersButton = new JButton("Submit Responses!");
        JLabel questionnaireInfolabel = new JLabel("Questionnaire answers run on a scale of 0-10 " +
                "(0 being the lowest, 10 being the highest!)");

        // slider questions
        // Get Questions
        qResponseModel = qPresenter.generate(qResponseModel);
        questionSet = qResponseModel.getRandQs();

        // Slider settings
        q1 = new JLabel("1." + " " + questionSet.get(0));
        slider1 = new JSlider(0, 10, 5);
        slider1.setMajorTickSpacing(1);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);

        q2 = new JLabel("2." + " " + questionSet.get(1));
        slider2 = new JSlider(0, 10, 5);
        slider2.setMajorTickSpacing(1);
        slider2.setPaintLabels(true);
        slider2.setPaintTicks(true);

        q3 = new JLabel("3." + " " + questionSet.get(2));
        slider3 = new JSlider(0, 10,5 );
        slider3.setMajorTickSpacing(1);
        slider3.setPaintLabels(true);
        slider3.setPaintTicks(true);

        q4 = new JLabel("4." + " " + questionSet.get(3));
        slider4 = new JSlider(0, 10, 5);
        slider4.setMajorTickSpacing(1);
        slider4.setPaintLabels(true);
        slider4.setPaintTicks(true);

        q5 = new JLabel("5." + " " + questionSet.get(4));
        slider5 = new JSlider(0, 10, 5);
        slider5.setMajorTickSpacing(1);
        slider5.setPaintLabels(true);
        slider5.setPaintTicks(true);

        // Message panel at top
        messagePanel.add(questionnaireInfolabel);

        // Building main JPanel (where all the UI elements are contained)
        mainPanel.add(q1);
        mainPanel.add(slider1);
        mainPanel.add(q2);
        mainPanel.add(slider2);
        mainPanel.add(q3);
        mainPanel.add(slider3);
        mainPanel.add(q4);
        mainPanel.add(slider4);
        mainPanel.add(q5);
        mainPanel.add(slider5);

        mainPanel.add(submitAnswersButton);


        // initializing frame w/ panel
        add(messagePanel, BorderLayout.PAGE_START);
        add(mainPanel, BorderLayout.CENTER);
        setTitle("Questionnaire Time!");
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // ActionListeners, ChangeListener, and user events
        submitAnswersButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double sum = 0;
        sum += slider1.getValue();
        sum += slider2.getValue();
        sum += slider3.getValue();
        sum += slider4.getValue();
        sum += slider5.getValue();
        double averageHappyScore = sum/5;
        setVisible(false); // "closes" this screen -> makes it invisible
        songRecWindow = new SongRecWindow(averageHappyScore);
        songRecWindow.setVisible(true);
    }

    public static void main(String[] args){
        new QuestionWindow();
    }
}

