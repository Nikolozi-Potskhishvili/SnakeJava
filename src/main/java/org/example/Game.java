package org.example;

public class Game {
    private boolean isRunning;
    Snake snake;

    Board board;

    Game(int w, int h) {
        isRunning = true;
        snake = new Snake(w / 2, h / 2);
        board = new Board(w,h);
    }

    public void strartGame() {
        while(isRunning) {
            if(snake.getHealth() <= 0) {
                isRunning = false;
            }

        }
    }
}
