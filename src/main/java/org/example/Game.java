package org.example;
import javax.swing.*;
import java.awt.event.*;
public class Game {
    private boolean isRunning;
    private Board board;

    private  Snake snake;

    private GameGraphics g;

    Game(int w, int h) {
        isRunning = true;
        board = new Board(w,h);
        snake = new Snake(w/2,h/2);
        board.updateSnakePos(snake);
        g = new GameGraphics(board);
        startGame();

    }

    private void startGame() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (snake.getHealth() == 0) {
                    isRunning = false;
                } else {
                    snake.moveSnake();
                    board.updateSnakePos(snake);
                    g.repaint();
                }
            }
        });
        // Start the timer
        timer.start();
    }

    private void handleImput() {

    }
}
