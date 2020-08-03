package com.khanh.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Human {
    private Vector2 position;
    private int size = 20;
    private int speed = 2;
    private Circle humanCircle;

    public Human() {
        position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    public void update() {
        move();
    }

    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x > 0) {
            position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x < Gdx.graphics.getWidth() - size) {
            position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && position.y < Gdx.graphics.getHeight() - size) {
            position.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y > 0) {
            position.y -= speed;
        }

//        if (position.x > Gdx.input.getX()) {
//            position.x -= 2;
//        } else if (position.x < Gdx.input.getX()){
//            position.x += 2;
//        }
//
//        if (position.y > Gdx.graphics.getHeight() - Gdx.input.getY()) {
//            position.y -= 2;
//        } else if (position.y <Gdx.graphics.getHeight() - Gdx.input.getY()){
//            position.y += 2;
//        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public Circle getHumanCircle() {
        return humanCircle;
    }
}
