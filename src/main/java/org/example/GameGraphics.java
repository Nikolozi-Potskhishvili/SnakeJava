package org.example;
import java.awt.*;
import javax.swing.*;

public class GameGraphics extends JFrame{
    private Board board;
    private GamePanel gamePanel;
    public GameGraphics(Board board) {
        this.board = board;
        int width = board.getBoardWidth();
        int height = board.getBoardHeight();

        JFrame frame = new JFrame("Snake game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width,height);

        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(width, height));
        gamePanel.setBackground(Color.GREEN);

        // Add the game panel to the JFrame
        add(gamePanel);

        // Make the JFrame visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());
            // Use the board data to render the game elements
            int[][] gameBoard = board.getBoard();
            int cellSize = Math.min(getWidth() / board.getBoardWidth(), getHeight() / board.getBoardHeight());

            for (int y = 0; y < board.getBoardHeight(); y++) {
                for (int x = 0; x < board.getBoardWidth(); x++) {
                    int cellValue = gameBoard[y][x];
                    if (cellValue == 1) {
                        g.setColor(Color.BLUE); // Snake
                    } else if (cellValue == 2) {
                        g.setColor(Color.RED); // Food
                    } else {
                        g.setColor(Color.GREEN); // Empty space
                    }

                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}
