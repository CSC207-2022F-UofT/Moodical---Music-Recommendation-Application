package UI;

import Boundaries.FavouritesInputBoundary;
import Boundaries.FavouritesOutputBoundary;
import Controllers.FavouritesController;
import Entities.Account;
import Entities.Favourites;
import Entities.History;
import Entities.Song;
import Presenters.FavouritesPresenter;
import Processors.FavouritesProcessor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        String [][] data = {{"Bad Romance by Lady Gaga"}, {"Just The Way You Are by Bruno Mars"},
                {"Cooler Than Me by Mike Posner"}, {"Teenage Dream by Katy Perry"}, {"Sexy Bitch by David Guetta"}};

//         String [][] data = FavouritesProcessor.toArray(FavouritesProcessor.userAccount);
        // called in presenter

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

        enterButton = new JButton("Add To Favourites");
        enterButton.setBounds(10, 80, 80, 25);
        enterButton.addActionListener(new FavouritesWindow());
//        f.add(enterButton);

        JScrollPane scrollPane = new JScrollPane(j);
        scrollPane.getViewport().setViewPosition(new Point(100, 100));
//        f.add(scrollPane, BorderLayout.BEFORE_LINE_BEGINS);

        JLabel j4 = new JLabel();
        j4.setBounds(5, 5, 500, 500);

        ImageIcon icon = new ImageIcon("program-images/mood.jpeg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(j4.getWidth(), j4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        j4.setIcon(scaledIcon);

        JPanel J = new JPanel(new GridLayout(2,1, 5,5));
        J.setBackground(Color.getHSBColor(164,219,232));

        J.add(scrollPane);
        J.add(j4);
        J.add(enterButton);
        J.add(text);

        f.add(J);

        scrollPane.setLocation(0, 100);
//        f.getContentPane().add(scrollPane);
        f.setSize(1000, 1000);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String song = text.getText();
        Account account = new Account("username", "password",
        new History(new ArrayList<ArrayList<Song>>()), new Favourites(new ArrayList<String>()));
        FavouritesOutputBoundary presenter = new FavouritesPresenter();
        FavouritesInputBoundary processor = new FavouritesProcessor(account, presenter);
        FavouritesController controller = new FavouritesController(processor);
        controller.generate(song);

    }

    public static void main(String[] args){
        new FavouritesWindow();
    }

}
