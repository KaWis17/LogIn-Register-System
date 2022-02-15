package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class RegisterWindow extends window {
    title title = new title("SignUp to bank");
    JPanel content = new JPanel();
    JLabel loginPanel = new JLabel("Login:");
    JLabel passwordPanel = new JLabel("Psw-rd:");
    JLabel repPasswordPanel = new JLabel("Repeat:");
    JTextField login = new JTextField();
    JPasswordField password = new JPasswordField();
    JPasswordField repPassword = new JPasswordField();
    button backlogButton = new button("Back to LogIn");
    button registerButton = new button("SignUp");

    private static final HashMap<String, String> dataBase = new HashMap<>();

    RegisterWindow() {
        content.setLayout(null);
        content.add(loginPanel);
        content.add(passwordPanel);
        content.add(repPasswordPanel);
        content.add(login);
        content.add(password);
        content.add(repPassword);
        content.add(backlogButton);
        content.add(registerButton);

        loginPanel.setBounds(40, 60, 85, 30);
        loginPanel.setFont(new Font("arial", Font.PLAIN, 20));
        login.setBounds(125, 60, 240, 30);
        passwordPanel.setBounds(40, 120, 85, 30);
        passwordPanel.setFont(new Font("arial", Font.PLAIN, 20));
        password.setBounds(125, 120, 240, 30);
        repPasswordPanel.setBounds(40, 180, 85, 30);
        repPasswordPanel.setFont(new Font("arial", Font.PLAIN, 20));
        repPassword.setBounds(125, 180, 240, 30);

        backlogButton.setBounds(40, 250, 125, 50);
        registerButton.setBounds(240, 250, 125, 50);
        backlogButton.addActionListener(e -> backToLogIn());
        registerButton.addActionListener(e -> registrationProcess());

        this.setTitle("Register Window");
        this.add(title, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void backToLogIn() {
        new LogInWindow();
        this.dispose();
    }

    private void registrationProcess() {
        if (!String.valueOf(password.getPassword()).equals(String.valueOf(repPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Passwords are not identical");
            password.setText("");
            repPassword.setText("");
        }
        else if(login.getText().length() < 4){
            JOptionPane.showMessageDialog(null, "Login is too short");
            login.setText("");
            password.setText("");
            repPassword.setText("");
        }
        else if(String.valueOf(password.getPassword()).length() < 4){
            JOptionPane.showMessageDialog(null, "Password is too short");
            login.setText("");
            password.setText("");
            repPassword.setText("");
        }
        else if (dataBase.containsKey(login.getText())) {
            JOptionPane.showMessageDialog(null, "Login is already taken");
            login.setText("");
            password.setText("");
            repPassword.setText("");
        }
        else {
            dataBase.put(login.getText(), String.valueOf(password.getPassword()));
            JOptionPane.showMessageDialog(null, "Account was successfully created");
            this.dispose();
            new LogInWindow();
        }
    }

    public static boolean getterContainsKey(String login){
        return dataBase.containsKey(login);
    }

    public static String getterValue(String login){
        return dataBase.get(login);
    }
}