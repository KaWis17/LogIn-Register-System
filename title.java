package com.company;

import javax.swing.*;
import java.awt.*;

public class title extends JLabel {
    title(String text){
        this.setText(text);
        this.setPreferredSize(new Dimension(300, 100));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setForeground(Color.white);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }
}
