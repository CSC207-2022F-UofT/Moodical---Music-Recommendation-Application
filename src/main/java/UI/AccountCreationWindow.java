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
        frame = new JFrame("Create an Account");
        frame.setSize(500, 300);
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        createUsername = new JLabel("Create a Username");
        createUsername.setBounds(100, 110, 200, 25);
        panel.add(createUsername);

        usernameInput = new JTextField();
        usernameInput.setBounds(225, 110, 200, 25);
        panel.add(usernameInput);

        createPassword = new JLabel("Create a Password");
        createPassword.setBounds(100, 130, 200, 25);
        panel.add(createPassword);

        passwordInput = new JTextField();
        passwordInput.setBounds(225, 130, 200, 25);
        panel.add(passwordInput);

        createAccount = new JButton("Create Account");
        createAccount.setBounds(75, 175, 175, 25);
        createAccount.addActionListener(this);
        panel.add(createAccount);

        BackToLogin = new JButton("Back to Login");
        BackToLogin.setBounds(250, 175, 175, 25);
        BackToLogin.addActionListener(this);
        panel.add(BackToLogin);

        successMessage = new JLabel("");
        successMessage.setBounds(300, 900, 100, 25);
        panel.add(successMessage);
        successMessage.setText("");

        frame.setVisible(true);
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
    public static void main(String[] args) { new AccountCreationWindow();}
}
