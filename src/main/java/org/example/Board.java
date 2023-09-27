package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Board {
    private int boardHeight;
    private int boardWidth;

    private final int[][] board;

    Board(int w, int h) {
        boardWidth = w;
        boardHeight = h;
        board = new int[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(board[i],0);
        }
    }

    public void updateSnakePos(Snake snake) {
        for(int i = 0; i < boardHeight; i++) {
            Arrays.fill(board[i],0);
        }
        for (int i = 0; i < snake.getSnk().size(); i++) {
            int[] pair = snake.getSnk().get(i);
            int x = pair[0];
            int y = pair[1];
            if(x < 0) {
                x = boardWidth - 1;
                snake.updateSnakeNode(i,x,y);
            } else if(x >= boardWidth) {
                x = 0;
                snake.updateSnakeNode(i,x,y);
            }
            if(y < 0) {
                y = boardHeight - 1;
                snake.updateSnakeNode(i,x,y);
            } else if(y >= boardHeight) {
                y = 0;
                snake.updateSnakeNode(i,x,y);
            }
            board[y][x] = 1;
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardHeight(int newHeight) {
        boardHeight = newHeight;
    }
    public void setBoardWidth(int newWidth) {
        boardWidth = newWidth;
    }
}
