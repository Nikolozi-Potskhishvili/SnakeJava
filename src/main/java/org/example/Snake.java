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
        snk = new LinkedList<>();
        int[] headPosition = {snakeHeadX, snakeHeadY};
        snk.add(headPosition);
        for(int i = 1; i < 20; i++) {
            int[] bodyPosition = {snakeHeadX, snakeHeadY - i};
            snk.add(bodyPosition);
        }
        this.direction = Direction.RIGHT;
    }

    void changeDirection(Direction direction) {
        this.direction = direction;
    }

    void moveSnake() {
        // Calculate the new head position based on the direction
        int newHeadX = snakeHeadX + direction.getDx();
        int newHeadY = snakeHeadY + direction.getDy();
        // Create a new head position
        int[] newHeadPosition = {newHeadX, newHeadY};
        // Add the new head to the front of the linked list
        snk.addFirst(newHeadPosition);
        // Remove the tail segment (last element) from the linked list
        snk.removeLast();
        // Update the snake's head position
        snakeHeadX = newHeadX;
        snakeHeadY = newHeadY;

    }

    LinkedList<int[]> getSnk() {
        return snk;
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
        snk.getLast()[0] = snakeHeadX;
    }

    @Override
    public void setY(int newY) {
        snakeHeadY = newY;
        snk.getLast()[1] = snakeHeadY;
    }
}
