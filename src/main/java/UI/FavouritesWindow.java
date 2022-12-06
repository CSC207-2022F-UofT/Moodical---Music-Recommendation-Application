package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.JTableHeader;

public class FavouritesWindow implements ActionListener {

    public static JFrame f;
    public static JTable j;

    public static JTextField text;

    public static JButton enterButton;
    public static void FavouritesWindow() {
        f = new JFrame();


        // Set the Frame colour
        f.setBackground(Color.getHSBColor(164, 219, 232));

        String[] columnNames = {"Favourites"};
        String [][] data = {{"song"}, {"song2"}, {"song3"}, {"song4"}, {"song5"}};
//          dummy data

//         String [][] data = FavouritesProcessor.toArray(FavouritesProcessor.userAccount);
        //called in presenter

        j = new JTable(data, columnNames);


        j.setBounds(50, 60, 100, 200);
        j.setRowHeight(100);

        // Set the colours
        j.setGridColor(Color.getHSBColor(164, 219, 232));

        // headers
        JTableHeader tableHeader = j.getTableHeader();
        tableHeader.setBackground(Color.getHSBColor(85, 118, 209));
        tableHeader.setPreferredSize(new Dimension(50, 50));

        text = new JTextField();
        text.setBounds(100, 20,165, 25);
        j.add(text);

        JScrollPane scrollPane = new JScrollPane(j);
        scrollPane.getViewport().setViewPosition(new Point(100, 100));
        f.add(scrollPane, BorderLayout.BEFORE_LINE_BEGINS);

        enterButton = new JButton("Add To Favourites");
        enterButton.setBounds(10, 80, 80, 25);
        enterButton.addActionListener(new FavouritesWindow());
        f.add(enterButton);

        scrollPane.setLocation(0, 100);
        f.getContentPane().add(scrollPane);
        f.setSize(1000, 1000);
        f.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        // this gets run everytime we click the Enter Button which we need to add to the text
        String song = text.getText();
        FavouritesResponseModel response = new FavouritesResponseModel();
        // note presenter unused as there is nothing to present
        response.addTo(song);
        // use response model to add the string to favourites?

    }
    // Driver  method
    public static void main(String[] args){
        new FavouritesWindow();

    }

}
