package UI;

import javax.swing.*;
import java.awt.*;
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
        frame.setBackground(Color.getHSBColor(164,219,232));
        panel.setBackground(Color.getHSBColor(164,219,232));

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
            QuestionWindow qw = new QuestionWindow();
            qw.QuestionWindow();}

        if (button.getSource() == BackToLogin) {
            // if button BackToLogin
            LoginWindow login = new LoginWindow();
            login.LoginWindow();
        }
    }
    public static void main(String[] args) { new AccountCreationWindow();}
}
