package UI;

import Presenters.HistoryRecPresenter;
import Processors.HistoryProcessor;
import Entities.Account;
import ResponseModels.HistoryResponseModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.JTableHeader;

public class HistoryWindow implements ActionListener {

    private static JPanel panel1;
    private static JTextArea textArea;
    public static JFrame f;
    public static JTable j;
    public static JButton rbutton;

    public static void Hwindow(String[][] data) {
        //technically takes in data as a param (calculated in the presenter and named table data) this came from the history
        //processor
        // Hwindow(String[][] data) and when calling hwindow input the table data in question
        f = new JFrame("History");

        // Set the Frame colour
        f.setBackground(Color.getHSBColor(164, 219, 232));


        //this is dummy data
        String[] columnNames = {"History"};
//        String[][] data = {{"song1, song2, song3, song4, song5, song6, song7, song8, song9, song10"},
//                {"song1, song2, song3, song4, song5, song6, song7, song8, song9, song10"},
//                {"song1, song2, song3, song4, song5, song6, song7, song8, song9, song10"},
//                {"song1, song2, song3, song4, song5, song6, song7, song8, song9, song10"},
//                {"song1, song2, song3, song4, song5, song6, song7, song8, song9, song10"},
//                {"song1, song2, song3, song4, song5, song6, song7, song8, song9, song10"}};

        j = new JTable(data, columnNames);


        j.setBounds(50, 60, 100, 200);
        j.setRowHeight(100);
        // Set the colours
        j.setGridColor(Color.getHSBColor(164, 219, 232));
        // headers
        JTableHeader tableHeader = j.getTableHeader();
        tableHeader.setBackground(Color.getHSBColor(85, 118, 209));
        tableHeader.setPreferredSize(new Dimension(50, 50));
        JScrollPane scrollPane = new JScrollPane(j);
        scrollPane.getViewport().setViewPosition(new Point(100, 100));
        f.add(scrollPane, BorderLayout.BEFORE_LINE_BEGINS);
        scrollPane.setLocation(0, 100);
        f.getContentPane().add(scrollPane);
//        JScrollPane sp = new JScrollPane(j);
//        f.add(sp);
        f.setSize(1000, 1000);
        f.setVisible(true);

        rbutton = new JButton("Get Reccomendation");
        rbutton.setBounds(10, 80, 80, 25);
        rbutton.addActionListener(new HistoryWindow());
        panel1.add(rbutton);




    }



    @Override
    public void actionPerformed(ActionEvent e){
        HistoryResponseModel response = new HistoryResponseModel();
        HistoryRecPresenter presenter = new HistoryRecPresenter();
        presenter.generate(response);



    }
    // Driver  method

}



