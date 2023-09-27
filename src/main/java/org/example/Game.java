package org.example;
import javax.swing.*;
import java.awt.event.*;
public class Game extends JFrame {
    private boolean isRunning;
    private final Board board;

    private final Snake snake;

    private final GameGraphics g;

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    Game(int w, int h) {
        isRunning = true;
        board = new Board(w,h);
        snake = new Snake(w/2,h/2);
        board.updateSnakePos(snake);
        g = new GameGraphics(board);
        g.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    upPressed = true;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    downPressed = true;
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    upPressed = false;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    downPressed = false;
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }
            }
        });
        startGame();

    }

    private void startGame() {
        Timer timer = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (snake.getHealth() == 0) {
                    isRunning = false;
                } else {
                    handleImput();
                    snake.moveSnake();
                    board.updateSnakePos(snake);
                    g.repaint();
                    if(snake.checkCollision()) snake.setSnakeHealth(snake.getHealth() - 1);
                }
            }
        });
        // Start the timer
        timer.start();
    }

    private void handleImput() {
        if (isUpKeyPressed()) {
            snake.setDirection(Direction.UP);
        } else if (isDownKeyPressed()) {
            snake.setDirection(Direction.DOWN);
        } else if (isLeftKeyPressed()) {
            snake.setDirection(Direction.LEFT);
        } else if (isRightKeyPressed()) {
            snake.setDirection(Direction.RIGHT);
        }
    }
    private boolean isUpKeyPressed() {
        return  upPressed;
    }

    private boolean isDownKeyPressed() {
        return downPressed;
    }

    private boolean isLeftKeyPressed() {
        return leftPressed;
    }

    private boolean isRightKeyPressed() {
        return rightPressed;
    }



}
