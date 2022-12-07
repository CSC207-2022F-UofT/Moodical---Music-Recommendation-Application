package UI;

import javax.swing.*;
import java.awt.*;
//This creates the pop up window when the user Hits Add to favourites and is called at the end of AddTo in the Use Case


public class FavouritesSuccessWindow extends JFrame {
    public static JPanel panel;
    public static JLabel successMessage;

    public FavouritesSuccessWindow(){
        panel = new JPanel();
        successMessage = new JLabel("SONG SUCCESSFULLY ADDED TO FAVOURITES");
        add(panel);

        setTitle("Add To Favourites");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        panel.setLayout(new GridLayout());
        successMessage = new JLabel("SONG SUCCESSFULLY ADDED TO FAVOURITES");
        panel.add(successMessage, BorderLayout.CENTER);
        successMessage.setHorizontalAlignment(SwingConstants.CENTER);

    }



}
