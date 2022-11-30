package UI;

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
    public JFrame f;
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

    public void DashboardWindow(){ // This will be taking an input of "all data" generated from analyse playlist processing later, once

        // The account reader works

        // Making a new J frame
        f = new JFrame();
        f.setTitle("Moodical"); // window title
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the Frame colour
        f.setBackground(Color.getHSBColor(164,219,232));

        // Layout of the dashboard
        //GridLayout layout = new GridLayout(0,2);
        J = new JPanel(new GridLayout(2,1, 5,5));

        // Table data
        String[] columnNames = {"Artists", "Genres", "Average Bmp", "Danceable"};
        String[][] data = {{"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"},
                {"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"}};
        String[] columnNames1 = {"Most Popular", "Happiest",
                "Saddest ", "Moodbooster"};
        String[][] data1 = {{"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"},
                {"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"}};

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

        f1.setSize(1100,1500);
        f1.setVisible(true);

        // Set the Frame colour
        f1.setBackground(Color.getHSBColor(164,219,232));

        // Making the buttons
        b3 = new JButton("I'm feeling okay");
        b4 = new JButton("I'm feeling sad");
        b5 = new JButton("I'm feeling happy");
        b6 = new JButton("I'm feeling happy");

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


    public static void main(String[] args) {} // this will be taking an input as well and be called by the presenter, in main

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b){ Hwindow(); }

        if(e.getSource() == b1){FavouritesWindow();}

        if(e.getSource() == b2){MemePage();}

        if(e.getSource() == b3){
            System.out.println("yay");}

        if(e.getSource() == b4){
            System.out.println("yayy");}

        if(e.getSource() == b5){MemePage();}

        if(e.getSource() == b6){
            System.out.println("yay");}

        }

}



