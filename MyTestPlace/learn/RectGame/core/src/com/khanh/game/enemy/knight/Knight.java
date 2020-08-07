package com.khanh.game.enemy.knight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.khanh.game.Game;

public class Knight {
    private float size = 20;
    private Vector2 position;
    private Circle circle;
    private Vector2 playerPosition;

    public Knight(float x) {
        position = new Vector2(x, (float) Math.random() * Gdx.graphics.getHeight());
        circle = new Circle();
    }

    public void update() {
        playerPosition = Game.player.getPosition();
        if (position.x < playerPosition.x) {
            if (position.y < playerPosition.y) {
                if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                    position.x++;
                    position.y += (playerPosition.y - position.y) / (playerPosition.x - position.x);
                } else {
                    position.x += (playerPosition.x - position.x) / (playerPosition.y - position.y);
                    position.y++;
                }
            } else{
                if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                    position.x++;
                    position.y += (playerPosition.y - position.y) / (playerPosition.x - position.x);
                } else {
                    position.x -= (playerPosition.x - position.x) / (playerPosition.y - position.y);
                    position.y--;
                }
            }
        } else {
            if (position.y < playerPosition.y) {
                if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                    position.x--;
                    position.y -= (playerPosition.y - position.y) / (playerPosition.x - position.x);
                } else {
                    position.x += (playerPosition.x - position.x) / (playerPosition.y - position.y);
                    position.y++;
                }
            } else {
                if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                    position.x--;
                    position.y -= (playerPosition.y - position.y) / (playerPosition.x - position.x);
                } else {
                    position.x -= (playerPosition.x - position.x) / (playerPosition.y - position.y);
                    position.y--;
                }
            }
        }
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
