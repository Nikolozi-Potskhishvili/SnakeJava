package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        init();

    }
    private static  void init() {
        JFrame frame = new JFrame("Snake game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        int w = 800;
        int h = 800;
        frame.setSize(w,h);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JButton playButton = new JButton("Play");


        JLabel label = new JLabel("Hello, press play button");
        panel.add(label);
        panel.add(playButton);

        frame.add(panel);
        frame.setVisible(true);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Game game = new Game(w,h);
            }
        });
    }
}