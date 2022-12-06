package UI;

import Boundaries.SongRecInputBoundary;
import Boundaries.SongRecOutputBoundary;
import Controllers.SongRecController;
import Entities.SongPool;
import Presenters.QuestionnairePresenter;
import Presenters.SongRecPresenter;
import Processors.CSVFileProcessing;
import Processors.SongAnalysisProcessing;
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

    private JPanel buttonPanel;

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
        messagePanel.setBackground(Color.getHSBColor(164,219,232));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 10));
        messagePanel.setLayout(new GridLayout());
        // Interaction Panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.getHSBColor(0,0,(float) 0.2)); // dark grey
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
        mainPanel.setLayout(new GridLayout(5, 1));
        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.getHSBColor(0,0,(float) 0.2)); // dark grey
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 30));
        buttonPanel.setLayout(new GridLayout());

        // submit button
        JButton submitAnswersButton = new JButton("Submit Responses!");
        submitAnswersButton.setVerticalAlignment(SwingConstants.CENTER);
        submitAnswersButton.setHorizontalAlignment(SwingConstants.LEFT);
        submitAnswersButton.setBackground(Color.getHSBColor(0,0,1));
        submitAnswersButton.setFont(new Font("Helvetica", Font.BOLD, 15));

        // info message at top
        JLabel questionnaireInfolabel = new JLabel("Questionnaire answers run on a scale of 0-10 " +
                "(0 being the lowest, 10 being the highest!)");
        questionnaireInfolabel.setFont(new Font("Seriff", Font.BOLD, 15));
        questionnaireInfolabel.setForeground(Color.getHSBColor(0,0,(float) 0.2)); // dark grey);
        questionnaireInfolabel.setHorizontalAlignment(SwingConstants.LEFT);

        // slider questions
        // Get Questions
        qResponseModel = qPresenter.generate(qResponseModel);
        questionSet = qResponseModel.getRandQs();

        // Slider settings
        q1 = new JLabel("<HTML>1." + "   " + questionSet.get(0) + "</HTML>");
        q1.setFont(new Font("Helvetica", Font.BOLD, 15));
        q1.setForeground(Color.getHSBColor(0,0,(float) 10));
        q1.setVerticalAlignment(SwingConstants.CENTER);
        slider1 = new JSlider(0, 10, 5);
        slider1.setMajorTickSpacing(1);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        slider1.setBackground(Color.getHSBColor(0,0, (float) 0.2));
        slider1.setFont(new Font("Helvetica", Font.BOLD, 15));
        slider1.setForeground(Color.getHSBColor(0,0,(float) 1));

        q2 = new JLabel("<HTML>2." + " " + questionSet.get(1) + "</HTML>");
        q2.setFont(new Font("Helvetica", Font.BOLD, 15));
        q2.setForeground(Color.getHSBColor(0,0,(float) 10));
        q2.setVerticalAlignment(SwingConstants.CENTER);
        slider2 = new JSlider(0, 10, 5);
        slider2.setMajorTickSpacing(1);
        slider2.setPaintLabels(true);
        slider2.setPaintTicks(true);
        slider2.setBackground(Color.getHSBColor(0,0, (float) 0.2));
        slider2.setFont(new Font("Helvetica", Font.BOLD, 15));
        slider2.setForeground(Color.getHSBColor(0,0,(float) 1));

        q3 = new JLabel("<HTML>3." + " " + questionSet.get(2) + "</HTML>");
        q3.setFont(new Font("Helvetica", Font.BOLD, 15));
        q3.setForeground(Color.getHSBColor(0,0,(float) 10));
        q3.setVerticalAlignment(SwingConstants.CENTER);
        slider3 = new JSlider(0, 10,5 );
        slider3.setMajorTickSpacing(1);
        slider3.setPaintLabels(true);
        slider3.setPaintTicks(true);
        slider3.setBackground(Color.getHSBColor(0,0, (float) 0.2));
        slider3.setFont(new Font("Helvetica", Font.BOLD, 15));
        slider3.setForeground(Color.getHSBColor(0,0,(float) 1));

        q4 = new JLabel("<HTML>4." + " " + questionSet.get(3) + "</HTML>");
        q4.setFont(new Font("Helvetica", Font.BOLD, 15));
        q4.setForeground(Color.getHSBColor(0,0,(float) 10));
        q4.setVerticalAlignment(SwingConstants.CENTER);
        slider4 = new JSlider(0, 10, 5);
        slider4.setMajorTickSpacing(1);
        slider4.setPaintLabels(true);
        slider4.setPaintTicks(true);
        slider4.setBackground(Color.getHSBColor(0,0, (float) 0.2));
        slider4.setFont(new Font("Helvetica", Font.BOLD, 15));
        slider4.setForeground(Color.getHSBColor(0,0,(float) 1));

        q5 = new JLabel("<HTML>5." + " " + questionSet.get(4) + "</HTML>");
        q5.setFont(new Font("Helvetica", Font.BOLD, 15));
        q5.setForeground(Color.getHSBColor(0,0,(float) 10));
        q5.setVerticalAlignment(SwingConstants.CENTER);
        slider5 = new JSlider(0, 10, 5);
        slider5.setMajorTickSpacing(1);
        slider5.setPaintLabels(true);
        slider5.setPaintTicks(true);
        slider5.setBackground(Color.getHSBColor(0,0, (float) 0.2));
        slider5.setFont(new Font("Helvetica", Font.BOLD, 15));
        slider5.setForeground(Color.getHSBColor(0,0,(float) 1));

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

        buttonPanel.add(submitAnswersButton);


        // initializing frame w/ panel
        add(messagePanel, BorderLayout.PAGE_START);
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setTitle("Questionnaire Time!");
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // ActionListeners, ChangeListener, and user events
        submitAnswersButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Integer> sliderValues = new ArrayList<>();
        sliderValues.add(slider1.getValue());
        sliderValues.add(slider2.getValue());
        sliderValues.add(slider3.getValue());
        sliderValues.add(slider4.getValue());
        sliderValues.add(slider5.getValue());
        setVisible(false); // "closes" this screen -> makes it invisible

        // create parts to plug into use case + entities engine
        CSVFileProcessing csvReader = new CSVFileProcessing();
        SongPool songPool = new SongPool();
        songPool.populateSongPool(csvReader, "dataset/songs.csv");

        SongRecOutputBoundary presenter = new SongRecPresenter();
        SongRecInputBoundary interactor = new SongAnalysisProcessing(presenter, songPool);
        SongRecController controller = new SongRecController(interactor);

        songRecWindow = new SongRecWindow(songPool, presenter, controller, interactor, sliderValues);
        songRecWindow.setVisible(true);
    }

    public static void main(String[] args){
        new QuestionWindow();
    }
}

