package com.khanh.firstproject;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

public class Bullet {
    public static final int BULLET_SIZE = 50;

    private Vector2 position;
    private int typeBullet;
    private static final int BL_NORMAL = 1;
    private Vector2 tankPositionInFire;
    private double bulletSpeedX;
    private double bulletSpeedY;
    private int cannonID;
    private boolean exist = true;
    private Rectangle recBullet;

    public Bullet(int x, int y, int id) {
        position = new Vector2(x, y);
        typeBullet = BL_NORMAL;
        cannonID = id;
        tankPositionInFire = new Vector2(tankgame.tankPosition.x, tankgame.tankPosition.y);
        recBullet = new Rectangle(position.x, position.y, BULLET_SIZE / 2, BULLET_SIZE / 2);
    }

    public Bullet() {
        exist = false;
    }

    public void cannon1Fire() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (position.x < tankgame.GAME_WIDTH && position.y < tankgame.GAME_HEIGHT) {
                    position.y += Math.sqrt((100 * Math.pow(tankPositionInFire.y, 2)) / (Math.pow(tankPositionInFire.x, 2) + Math.pow(tankPositionInFire.y, 2)));
                    position.x += Math.sqrt(100 - Math.pow(Math.sqrt((100 * Math.pow(tankPositionInFire.y, 2)) / (Math.pow(tankPositionInFire.x, 2) + Math.pow(tankPositionInFire.y, 2))), 2));
                    recBullet.setPosition(position.x, position.y);
                    cannon1Fire();
                } else exist = false;
            }
        }, (float) 0.01);
    }

    public void cannon2Fire() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (position.x < tankgame.GAME_WIDTH && position.y > 0) {
                    position.y -= Math.sqrt((100 * Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2)) / (Math.pow(tankPositionInFire.x, 2) + Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2)));
                    position.x += Math.sqrt(100 - Math.pow(Math.sqrt((100 * Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2)) / (Math.pow(tankPositionInFire.x, 2) + Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2))), 2));
                    recBullet.setPosition(position.x, position.y);
                    cannon2Fire();
                } else {
                    exist = false;
                }
            }
        }, (float) 0.01);
    }

    public void cannon3Fire() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (position.x > 0 && position.y < tankgame.GAME_HEIGHT) {
                    position.y += Math.sqrt((100 * Math.pow(tankPositionInFire.y, 2)) / (Math.pow(tankgame.GAME_WIDTH - tankPositionInFire.x, 2) + Math.pow(tankPositionInFire.y, 2)));
                    position.x -= Math.sqrt(100 - Math.pow(Math.sqrt((100 * Math.pow(tankPositionInFire.y, 2)) / (Math.pow(tankgame.GAME_WIDTH - tankPositionInFire.x, 2) + Math.pow(tankPositionInFire.y, 2))), 2));
                    recBullet.setPosition(position.x, position.y);
                    cannon3Fire();
                } else {
                    exist = false;
                }
            }
        }, (float) 0.01);
    }

    public void cannon4Fire() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (position.x > 0 && position.y > 0) {
                    position.y -= Math.sqrt((100 * Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2)) / (Math.pow(tankgame.GAME_WIDTH - tankPositionInFire.x, 2) + Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2)));
                    position.x -= Math.sqrt(100 - Math.pow(Math.sqrt((100 * Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2)) / (Math.pow(tankgame.GAME_WIDTH - tankPositionInFire.x, 2) + Math.pow(tankgame.GAME_HEIGHT - tankPositionInFire.y, 2))), 2));
                    recBullet.setPosition(position.x, position.y);
                    cannon4Fire();
                } else {
                    exist = false;
                }
            }
        }, (float) 0.01);
    }

    public boolean exist() {
        return exist;
    }

    public int getCannonID() {
        return cannonID;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRecBullet() {
        return recBullet;
    }
}
