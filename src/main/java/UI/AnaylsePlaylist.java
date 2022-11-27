package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTable;
import Controllers.AnalysePlaylistController;
import javax.swing.JFrame;
import javax.swing.table.JTableHeader;

import java.util.ArrayList;

public class AnaylsePlaylist {
    private JPanel panel1;
    private JTextArea textArea;
    JFrame f;
    JTable j;

    AnaylsePlaylist() {

        f = new JFrame();


        // Set the Frame colour
        f.setBackground(Color.getHSBColor(164,219,232));

        String[] columnNames = {"Artists", "Genres", "Average Bmp", "Danceable", "Most Popular", "Happiest",
                "Saddest ", "Moodbooster"};
        String[][] data = {{"1","2","3","4","5","6","7","8"}, {"1","2","3","4","5","6","7","8"},
                {"1","2","3","4","5","6","7","8"}};

//        Object[] allData = AnalysePlaylistController.getAllData().toArray();

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
        scrollPane.getViewport().setViewPosition(new Point(100,100));
        f.add(scrollPane, BorderLayout.BEFORE_LINE_BEGINS);
        scrollPane.setLocation(0,100);
        f.getContentPane().add(scrollPane);
//        JScrollPane sp = new JScrollPane(j);
//        f.add(sp);
        f.setSize(1000,1000);
        f.setVisible(true);


    }

    public static void main(String[] args){
        new AnaylsePlaylist();
    }
}


