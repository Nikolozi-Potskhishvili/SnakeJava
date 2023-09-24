package org.example;

public class Board {
    private int boardHeight;
    private int boardWidth;

    Board(int w, int h) {
        boardWidth = w;
        boardHeight = h;
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
