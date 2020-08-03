package com.khanh.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Bomb {
    private float size = 20;
    private Vector2 position;
    private Circle circle;

    public Bomb(float x) {
        position = new Vector2(x, (float) Math.random() * Gdx.graphics.getHeight());
        circle = new Circle();
    }

    public void update() {

        if (RectGame.human.getPosition().x > position.x && RectGame.human.getPosition().y > position.y) {
            if (Math.abs(RectGame.human.getPosition().x - position.x) > Math.abs(RectGame.human.getPosition().y - position.y)) {
                position.y += (RectGame.human.getPosition().y - position.y) / (RectGame.human.getPosition().x - position.x);
                position.x++;
            } else {
                position.y++;
                position.x += (RectGame.human.getPosition().x - position.x) / (RectGame.human.getPosition().y - position.y);
            }
        } else {
            if (Math.abs(RectGame.human.getPosition().x - position.x) > Math.abs(RectGame.human.getPosition().y - position.y))
            {
                position.y -= (RectGame.human.getPosition().y - position.y) / (RectGame.human.getPosition().x - position.x);
                position.x--;
            }else {
                position.y--;
                position.x -= (RectGame.human.getPosition().x - position.x) / (RectGame.human.getPosition().y - position.y);
            }
        }

        circle.set(position.x, position.y, size / 2);
    }


    public Vector2 getPosition() {
        return position;
    }

    public Circle getCircle() {
        return circle;
    }

    public float getSize() {
        return size;
    }
}
