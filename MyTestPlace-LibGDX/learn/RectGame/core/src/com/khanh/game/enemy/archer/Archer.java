package com.khanh.game.enemy.archer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.khanh.game.Game;

public class Archer {
    private final int ZONE_CAN_FIRE = 200;
    private final int DANGLE_ZONE = 100;
    private Vector2 position;
    private int size = 20;
    private Vector2 playerPosition;
    private Circle circleArcher;
    private Circle zoneCanFire;
    private Circle dangleZone;
    private Arrow arrow;

    public Archer() {
        playerPosition = new Vector2();
        playerPosition = Game.player.getPosition();
        zoneCanFire = new Circle();
        dangleZone = new Circle();
        circleArcher = new Circle();
        position = new Vector2((float) Math.random() * Gdx.graphics.getWidth(), (float) Math.random() * Gdx.graphics.getHeight());
        archerFire();
    }

    public void update() {
        playerPosition = Game.player.getPosition();
        zoneCanFire.set(playerPosition.x, playerPosition.y, ZONE_CAN_FIRE);
        dangleZone.set(playerPosition.x, playerPosition.y, DANGLE_ZONE);
        circleArcher.set(position.x, position.y, size);
        if (circleArcher.overlaps(dangleZone)) {
            if (position.x < playerPosition.x) {
                if (position.y < playerPosition.y) {
                    if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                        position.x--;
                        position.y -= (playerPosition.y - position.y) / (playerPosition.x - position.x);
                    } else {
                        position.x -= (playerPosition.x - position.x) / (playerPosition.y - position.y);
                        position.y--;
                    }
                } else {
                    if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                        position.x--;
                        position.y -= (playerPosition.y - position.y) / (playerPosition.x - position.x);
                    } else {
                        position.x += (playerPosition.x - position.x) / (playerPosition.y - position.y);
                        position.y++;
                    }
                }
            } else {
                if (position.y < playerPosition.y) {
                    if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                        position.x++;
                        position.y += (playerPosition.y - position.y) / (playerPosition.x - position.x);
                    } else {
                        position.x -= (playerPosition.x - position.x) / (playerPosition.y - position.y);
                        position.y--;
                    }
                } else {
                    if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                        position.x++;
                        position.y += (playerPosition.y - position.y) / (playerPosition.x - position.x);
                    } else {
                        position.x += (playerPosition.x - position.x) / (playerPosition.y - position.y);
                        position.y++;
                    }
                }
            }
        }
        if (!circleArcher.overlaps(zoneCanFire)) {
            if (position.x < playerPosition.x) {
                if (position.y < playerPosition.y) {
                    if (Math.abs(playerPosition.x - position.x) > Math.abs(playerPosition.y - position.y)) {
                        position.x++;
                        position.y += (playerPosition.y - position.y) / (playerPosition.x - position.x);
                    } else {
                        position.x += (playerPosition.x - position.x) / (playerPosition.y - position.y);
                        position.y++;
                    }
                } else {
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
    }

    public void archerFire() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                arrow = new Arrow(playerPosition);
            }
        }, 3);
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getSize() {
        return size;
    }
}
