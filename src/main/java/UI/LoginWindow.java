package UI;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

    public class LoginWindow implements ActionListener {
        JFrame frame;
        JPanel panel;
        JLabel welcomeMessage;
        JButton createAccount;
        JLabel usernameLabel;
        JTextField usernameText;
        JLabel passwordLabel;
        JPasswordField passwordCover;
        JButton enterButton;
        JLabel successMessage;

        LoginWindow() {
            frame = new JFrame("Login Window");
            frame.setSize(1000, 1000);

            panel = new JPanel();
            frame.add(panel);

            panel.setLayout(null);

            welcomeMessage = new JLabel("Feeling Mood-ical? Login to begin!");
            welcomeMessage.setBounds(250, 100, 100, 100);
            panel.add(welcomeMessage);

            createAccount = new JButton("Create an account");
            createAccount.setBounds(250, 300, 100, 100);
            createAccount.addActionListener(new LoginWindow());
            panel.add(createAccount);

            usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(250, 500, 100, 100);
            panel.add(usernameLabel);

            usernameText = new JTextField();
            usernameText.setBounds(400, 500, 100, 100);
            panel.add(usernameText);

            passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(250, 700, 100, 100);
            panel.add(passwordLabel);

            passwordCover = new JPasswordField();
            passwordCover.setBounds(400, 700, 100, 100);
            panel.add(passwordCover);

            enterButton = new JButton("Login");
            enterButton.setBounds(250, 900, 50,50);
            enterButton.addActionListener(new LoginWindow());
            panel.add(enterButton);

            successMessage = new JLabel("");
            successMessage.setBounds(250, 950, 50,50);
            panel.add(successMessage);
            successMessage.setText("");

            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent button) {
            String username = usernameText.getText();
            String password = passwordCover.getText();

            if (button.getSource() == createAccount) {
                new AccountCreationWindow();
            } else {
                RequestModels.UserAccountRequestModel requestModel =
                        new RequestModels.UserAccountRequestModel(username, password,
                                RequestModels.UserAccountRequestModel.createEmptyHistoryObject(),
                                RequestModels.UserAccountRequestModel.createEmptyFavouritesObject());
                try {
                    if (Controllers.UserAccountController.returnUserExistence(requestModel)) {
                        successMessage.setText("Login Successful");
                    } else {
                        successMessage.setText("User not found. Please create an account");
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public static void main(String[] args) {
            new LoginWindow();
        }
    }


