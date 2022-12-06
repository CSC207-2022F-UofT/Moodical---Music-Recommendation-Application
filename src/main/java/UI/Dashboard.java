package UI;

import Processors.FavouritesProcessor;
import Processors.HistoryProcessor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;
import javax.swing.table.JTableHeader;
import java.awt.event.*;

import static UI.HistoryWindow.Hwindow;
import static UI.FavouritesWindow.FavouritesWindow;


public class Dashboard  extends JFrame implements ActionListener {
    private static JPanel panel;
    private static JTextArea textArea;
    public static JFrame f;
    public static JFrame f1;
    public static JTable j;
    public static JPanel J;
    public static JPanel J1;
    public static JButton b;
    public static JButton b1;
    public static JButton b2;
    public static JButton b3;
    public static JButton b4;
    public static JButton b5;
    public static JButton b6;

    public void DashboardWindow(){

        // Making a new J frame
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the Frame colour
        f.setBackground(Color.getHSBColor(164,219,232));

        // Layout of the dashboard
        //GridLayout layout = new GridLayout(0,2);
        J = new JPanel(new GridLayout(2,1, 5,5));

        // Table data
        String[] columnNames = {"Artists", "Genres", "Average Bmp", "Danceable"};
        String[][] data = {{"Kesha","Pop","55.5","45.6"}, {"Lady Gaga","Rock","34.5","Your Love is My Drug"},
                {"Justin Biber","Indie","45.3","Friends"}, {"Bruno Mars","Pop Rock","67.8","Just Dance"}};
        String[] columnNames1 = {"Most Popular", "Happiest",
                "Saddest ", "Moodbooster"};
        String[][] data1 = {{"Sparks","Just the Way you Are","The One that Got Away","Teenage Dream"},
                {"Scientist","Marry You","Mean","Happier"},
                {"Sorry","Cooler Than Me","I Know I'm not the Only One","Lover"},
                {"Only Girl","Cardigan","In My Blood","Bad Romance"}};

//      Object[] allData = playlist.getAllData().toArray();  this is the actual data we will be using

        // Making the first JTable
        j = new JTable(data, columnNames);
        j.setBounds(50, 60, 100, 200);
        j.setRowHeight(100);

        // Set the colours
        j.setGridColor(Color.getHSBColor(164,219,232));

        // headers
        JTableHeader tableHeader = j.getTableHeader();
        tableHeader.setBackground(Color.getHSBColor(85,118,209));
        tableHeader.setPreferredSize(new Dimension(50,50));

        JScrollPane scrollPane = new JScrollPane(j);
        scrollPane.getViewport().setViewPosition(new Point(0,0));
        scrollPane.setLocation(0,0);

        // Making the second JTable
        j = new JTable(data1, columnNames1);
        j.setBounds(50, 60, 100, 200);
        j.setRowHeight(100);

        // Set the colours
        j.setGridColor(Color.getHSBColor(164,219,232));

        // headers
        JTableHeader tableHeader1 = j.getTableHeader();
        tableHeader1.setBackground(Color.getHSBColor(85,118,209));
        tableHeader1.setPreferredSize(new Dimension(50,50));

        JScrollPane scrollPane1 = new JScrollPane(j);
        scrollPane.getViewport().setViewPosition(new Point(0,0));
        scrollPane.setLocation(0,0);


        // Making the buttons
        b = new JButton("History");
        b1 = new JButton("Favourites");
        b2 = new JButton("Your daily dose of Serotonin");

        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        b.setBackground(Color.PINK);
        b1.setBackground(Color.PINK);
        b2.setBackground(Color.PINK);

        b.setFocusPainted(false);

        // Adding the image
        JLabel jLabel = new JLabel();
        jLabel.setBounds(5, 5, 336, 434);

        ImageIcon icon = new ImageIcon("program-images/mood.jpeg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel.setIcon(scaledIcon);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        J.add(scrollPane);
        J.add(scrollPane1);
        J.add(jLabel);

        J.add(b);
        J.add(b1);
        J.add(b2);

        f.add(J);
        f.pack();

        f.setSize(1100,1500);
        f.setVisible(true);
    }

    public void MemePage() {

        f1 = new JFrame();
        f1.setBackground(Color.getHSBColor(164,219,232));

        f1.setSize(1100,1500);
        f1.setVisible(true);

        // Set the Frame colour
        f1.setBackground(Color.getHSBColor(164,219,232));

        // Making the buttons
        b3 = new JButton("I'm feeling okay");
        b4 = new JButton("I'm feeling sad");
        b5 = new JButton("I'm feeling happy");
        b6 = new JButton("I'm feeling unmotivated");

        b3.setBackground(Color.PINK);
        b4.setBackground(Color.PINK);
        b5.setBackground(Color.PINK);
        b6.setBackground(Color.PINK);

        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        J1 = new JPanel(new GridLayout(2,1, 5,5));

        J1.add(b3);
        J1.add(b4);
        J1.add(b5);
        J1.add(b6);

        f1.add(J1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b){Hwindow(); }

        if(e.getSource() == b1){FavouritesWindow(FavouritesProcessor.toArray(FavouritesProcessor.userAccount));}

        if(e.getSource() == b2){MemePage();}

        if(e.getSource() == b3){

            JLabel j2 = new JLabel();
            j2.setBounds(5, 5, 500, 500);

            ImageIcon icon = new ImageIcon("program-images/betterdays.jpeg");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(j2.getWidth(), j2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            j2.setIcon(scaledIcon);

            JFrame f3 = new JFrame();
            f3.setBackground(Color.getHSBColor(164,219,232));
            f3.add(j2);
            f3.setSize(500, 500);

            f3.setVisible(true);}

        if(e.getSource() == b4){

            JLabel j4 = new JLabel();
            j4.setBounds(5, 5, 500, 500);

            ImageIcon icon = new ImageIcon("program-images/beokay.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(j4.getWidth(), j4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            j4.setIcon(scaledIcon);

            JFrame f5 = new JFrame();
            f5.setBackground(Color.getHSBColor(164,219,232));
            f5.add(j4);
            f5.setSize(500, 500);

            f5.setVisible(true);}

        if(e.getSource() == b5){
            JLabel j5 = new JLabel();
            j5.setBounds(5, 5, 500, 500);

            ImageIcon icon = new ImageIcon("program-images/Happiness.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(j5.getWidth(), j5.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            j5.setIcon(scaledIcon);

            JFrame f6 = new JFrame();
            f6.setBackground(Color.getHSBColor(164,219,232));
            f6.add(j5);
            f6.setSize(500, 500);

            f6.setVisible(true);}


        if(e.getSource() == b6){
            JLabel j6 = new JLabel();
            j6.setBounds(5, 5, 500, 500);

            ImageIcon icon = new ImageIcon("program-images/motivation.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(j6.getWidth(), j6.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            j6.setIcon(scaledIcon);

            JFrame f7 = new JFrame();
            f7.setBackground(Color.getHSBColor(164,219,232));
            f7.add(j6);
            f7.setSize(500, 500);

            f7.setVisible(true);}

        }

}



