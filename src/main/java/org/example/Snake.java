package org.example;

import java.util.LinkedList;

public class Snake implements   GameObject{
    private int snakeHeadX;

    private int snakeHeadY;

    private int snakeHealth = 3;

    private int snakeLength;

    private Direction direction;

    LinkedList<int[]> snk;

    Snake(int xPos,int yPos) {
        snakeHeadY = yPos;
        snakeHeadX = xPos;
        int[] headPosition = {snakeHeadX, snakeHeadY};
        snk = new LinkedList<>();
        snk.add(headPosition);
        this.direction = Direction.RIGHT;
    }

    void moveSnake() {
        snakeHeadX += direction.getDx();
        snakeHeadY += direction.getDy();
    }

    public void setSnakeHealth(int newHealth) {
       snakeHealth = newHealth;
    }

    public int getHealth() {
        return snakeHealth;
    }

    public int getSnakeLength() {
        return snakeLength;
    }

    @Override
    public int getX() {
        return snakeHeadX;
    }

    @Override
    public int getY() {
        return snakeHeadY;
    }

    @Override
    public void setX(int newX) {
        snakeHeadX = newX;
    }

    @Override
    public void sexY(int newY) {
        snakeHeadY = newY;
    }
}
