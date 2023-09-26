package org.example;

public class Food implements GameObject{
    int foodPosX;

    int foodPosY;

    @Override
    public int getX() {
        return foodPosX;
    }

    @Override
    public int getY() {
        return foodPosY;
    }

    @Override
    public void setX(int newX) {
        foodPosX = newX;
    }

    @Override
    public void setY(int newY) {
        foodPosY = newY;
    }
}
