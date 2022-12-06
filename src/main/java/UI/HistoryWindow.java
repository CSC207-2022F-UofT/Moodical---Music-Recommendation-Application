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

    public static JPanel j1;
    private static JTextArea textArea;
    public static JFrame f;
    public static JTable j;
    public static JButton rbutton;

    public static void Hwindow() {

        f = new JFrame("History");

        // Set the Frame colour
        f.setBackground(Color.getHSBColor(164, 219, 232));


        //this is dummy data
        String[] columnNames = {"History"};
        String[][] data = {{"Bad Romance, Just The Way You Are, Only Girl In The World, Cooler Than Me, Marry You"},
                {"Your Love is My Drug, Take It Off, Teenage Dream, My First Kiss, Sexy Bitch"}};

        // the above data is hard coded for presentation demonstration purposes, when fully functioning History Processor
        // to Array function will format the History Data into a String[][] and can be passed to the UI

        // with clean arch:


        j1 = new JPanel(new GridLayout(2,1, 5,5));
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

        j1.add(scrollPane);

        rbutton = new JButton("Get Reccomendation");
        rbutton.setBounds(10, 80, 80, 25);
        rbutton.addActionListener(new HistoryWindow());
        rbutton.setBackground(Color.PINK);
        j1.add(rbutton);

        f.add(j1);

        f.setSize(1000, 1000);
        f.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == rbutton) {
        HistorySongRecWindow his = new HistorySongRecWindow();
        his.HistorySongRecWindow1();}

    }


}