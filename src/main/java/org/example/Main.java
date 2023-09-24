package org.example;
import java.awt.*;
import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends  Canvas{
    public static void main(String[] args) {
        init();

    }
    private static  void init() {
        Canvas cn = new Canvas();
        JFrame frame = new JFrame();
        JButton button = new JButton();
        cn.setBackground(Color.BLACK);
        frame.add(cn);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}