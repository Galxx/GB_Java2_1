package com.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;

class MyWindow4 extends JFrame {
    public MyWindow4() {
            setBounds(500,500,500,300);
            setTitle("BoxLayoutDemo");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JButton[] jbs = new JButton[10];
//            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // одну из строк надо закомментировать
            setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); // одну из строк надо закомментировать
            for (int i = 0; i < jbs.length; i++) {
                jbs[i] = new JButton("#" + i);
                jbs[i].setAlignmentX(CENTER_ALIGNMENT);
                add(jbs[i]);
            }
            setVisible(true);
        }
}

public class MainClass4 {
    public static void main(String[] args) {
        new MyWindow4();
    }
}
