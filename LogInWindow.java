package com.company;

import javax.swing.*;
import java.awt.*;

public class LogInWindow extends window {

    title title = new title("LogIn to Bank");
    JPanel content = new JPanel();
    JLabel loginPanel = new JLabel("Login:");
    JLabel passwordPanel = new JLabel("Psw-rd:");
    JTextField login = new JTextField();
    JPasswordField password = new JPasswordField();
    button loginButton = new button("LogIn");
    button registerButton = new button("Register");

    LogInWindow(){
        content.setLayout(null);
        content.add(loginPanel);
        content.add(login);
        content.add(passwordPanel);
        content.add(password);
        content.add(loginButton);
        content.add(registerButton);

        loginPanel.setBounds(40,75,85,30);
        loginPanel.setFont(new Font("arial", Font.PLAIN, 20));
        login.setBounds(125,75,240,30);
        passwordPanel.setBounds(40,135, 85,30);
        passwordPanel.setFont(new Font("arial", Font.PLAIN, 20));
        password.setBounds(125,135,240,30);

        loginButton.setBounds(40,225, 125,50);
        registerButton.setBounds(240,225,125,50);
        registerButton.addActionListener(e -> openRegistration());
        loginButton.addActionListener(e -> openLoggedWindow());

        this.setTitle("Sign in Window");
        this.add(title, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void openRegistration(){
        new RegisterWindow();
        this.dispose();
    }

    private void openLoggedWindow(){
        if(!RegisterWindow.getterContainsKey(login.getText())){
            JOptionPane.showMessageDialog(null, "Account with this login does not exist!!!");
            login.setText("");
            password.setText("");
        }
        else if(!RegisterWindow.getterValue(login.getText()).equals(String.valueOf(password.getPassword()))){
            JOptionPane.showMessageDialog(null, "Invalid Password");
            login.setText("");
            password.setText("");
        }
        else{
            new LoggedInWindow(login.getText());
            this.dispose();
        }

    }
}
