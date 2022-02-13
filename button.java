package com.company;

import javax.swing.*;
import java.awt.*;

public class button extends JButton {
    button(String text){
        this.setText(text);
        this.setBackground(Color.lightGray);
        this.setFocusable(false);

    }
}
