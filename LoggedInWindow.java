package com.company;

import javax.swing.*;
import java.awt.*;

public class LoggedInWindow extends window {
    title title = new title("Welcome");
    button logout = new button("Log out");
    LoggedInWindow(String login){
        title.setText("Welcome " + login);
        logout.addActionListener(e -> logoutProcess());
        this.setTitle("LoggedIn Window");
        this.add(title, BorderLayout.NORTH);
        this.add(logout, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void logoutProcess(){
        this.dispose();
        new LogInWindow();
        JOptionPane.showMessageDialog(null, "You have been successfully logged out");
    }
}
