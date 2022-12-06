package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreationWindow implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel createUsername;
    JTextField usernameInput;
    JLabel createPassword;
    JTextField passwordInput;
    JButton createAccount;
    JLabel successMessage;
    JButton BackToLogin;

    AccountCreationWindow() {
        frame = new JFrame("Login Window");
        frame.setSize(1000, 1000);
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        createUsername = new JLabel("Enter a Username");
        createUsername.setBounds(250, 100, 100, 100);
        panel.add(createUsername);

        usernameInput = new JTextField();
        usernameInput.setBounds(400, 300, 100, 100);
        panel.add(usernameInput);

        createPassword = new JLabel("Password");
        createPassword.setBounds(250, 500, 100, 100);
        panel.add(createPassword);

        passwordInput = new JTextField();
        passwordInput.setBounds(400, 500, 100, 100);
        panel.add(passwordInput);

        createAccount = new JButton("Create Account");
        createAccount.setBounds(250, 700, 100, 100);
        createAccount.addActionListener(new AccountCreationWindow());
        panel.add(createAccount);

        BackToLogin = new JButton("Back to Login");
        BackToLogin.setBounds(400, 700, 100, 100);
        BackToLogin.addActionListener(new LoginWindow());
        panel.add(BackToLogin);

        successMessage = new JLabel("");
        successMessage.setBounds(250, 900, 100, 100);
        panel.add(successMessage);
        successMessage.setText("");
        }

        @Override
        public void actionPerformed(ActionEvent button) {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            if (button.getSource() == createAccount) {
                RequestModels.UserAccountRequestModel requestModel =
                        new RequestModels.UserAccountRequestModel(username, password,
                                RequestModels.UserAccountRequestModel.createEmptyHistoryObject(),
                                RequestModels.UserAccountRequestModel.createEmptyFavouritesObject());
                Controllers.UserAccountController.registerAccount(requestModel);
                successMessage.setText("Account Creation Successful! Click Login");
            } else { // if button BackToLogin
                new LoginWindow();
            }
        }
    }


