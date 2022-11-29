package UI;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.JTableHeader;

public class Dashboard  extends JFrame{
    private JPanel panel;
    private JTextArea textArea;
    JFrame f;
    JTable j;
    JPanel J;
    JButton b;
    JButton b1;
    JButton b2;
    JButton b3;

    Dashboard(){

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
        String[][] data = {{"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"},
                {"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"}};
        String[] columnNames1 = {"Most Popular", "Happiest",
                "Saddest ", "Moodbooster"};
        String[][] data1 = {{"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"},
                {"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"}};

//      Object[] allData = playlist.getAllData().toArray();

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
        b2 = new JButton("Profile");

        b.setBackground(Color.MAGENTA);

        b.setFocusPainted(false);

        // Adding the image
        JLabel jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon("/Users/savannapan/IdeaProjects/course-project-group-120/src/main/java/mood.jpeg"));
        jLabel.setBounds(5, 5, 336, 434);


        J.add(scrollPane);
        J.add(scrollPane1);
        J.add(jLabel);

        J.add(b);
        J.add(b1);
        J.add(b2);

        f.add(J);
        f.pack();

        validate();
        f.setSize(1100,1500);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new Dashboard();}
}



