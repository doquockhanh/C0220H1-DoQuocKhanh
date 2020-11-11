package com.mygdx.game.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Gunner {
    private static final int AIM = 1;
    private static final int FIRE = 2;
    private static final int FIRING = 4;
    private static final int BULLET_DISPOSE = 3;
    private static final int CHARACTER_LOOK_LEFT = -45;
    private static final int CHARACTER_LOOK_RIGHT = 45;
    private static final int CHARACTER_MOVE_SPEED = 1;

    private Vector2 characterCoordinate;
    private Vector2 characterSize;
    private int characterPosition = CHARACTER_LOOK_LEFT;
    private int gunnerFrameCount;
    private float flagIncreaseFrame;

    //  thuộc tính đạn
    private Vector2 bulletCoordinate;
    private Vector2 bulletSize;
    private int bulletStatus;
    private double bulletSpeedX;
    private double bulletSpeedY;
    private double timer = 0;
    private double fireAngle = 180 - (characterPosition);
    private int bulletPower;
    private float cosX = (float) Math.cos(-Math.PI * fireAngle / 180);
    private float sinY = (float) -Math.sin(-Math.PI * fireAngle / 180);

    public Gunner() {
        characterCoordinate = new Vector2(300, 200);
        characterSize = new Vector2(60, 60);

        bulletSize = new Vector2(15, 15);
        bulletStatus = AIM;
        bulletCoordinate = new Vector2();
        bulletCoordinate.x = characterCoordinate.x + characterSize.x / 2 + 80 * cosX;
        bulletCoordinate.y = characterCoordinate.y + characterSize.y / 2 + 80 * sinY;
        gunnerFrameCount = 0;
    }

    public void gunnerController() {
        if (bulletStatus != FIRING) {
            characterMoveAndAngle();
        }

        if (bulletStatus == FIRE) {
            gunnerFire();
        }
        if (bulletStatus == FIRING) {
            bulletFiring(0.0001);
        }

//      điểm xuất hiện đạn
        cosX = (float) Math.cos(-Math.PI * fireAngle / 180);
        sinY = (float) -Math.sin(-Math.PI * fireAngle / 180);

    }

    public void gunnerFire() {
//      tốc độ đạn ban đầu
        bulletSpeedY = -bulletPower * 0.06 * Math.sin(Math.PI * fireAngle / 180);
        bulletSpeedX = bulletPower * 0.06 * Math.cos(Math.PI * fireAngle / 180);
        bulletStatus = FIRING;
    }

    public void bulletFiring(double wind) {
        timer += 0.06;
        bulletCoordinate.x += bulletSpeedX;
        bulletCoordinate.y -= bulletSpeedY;
        double gravity = 0.1;
        bulletSpeedY += gravity;
        bulletSpeedX -= timer * wind;
        if (bulletCoordinate.x > Gdx.graphics.getWidth() || bulletCoordinate.x < 0 || bulletCoordinate.y > Gdx.graphics.getHeight() || bulletCoordinate.y < 0) {
            bulletStatus = BULLET_DISPOSE;
            bulletCoordinate.x = characterCoordinate.x + characterSize.x / 2 + 80 * cosX;
            bulletCoordinate.y = characterCoordinate.y + characterSize.y / 2 + 80 * sinY;
            bulletStatus = AIM;
            bulletPower = 0;
        }
    }

    private boolean flagFire;
    private boolean flagAIM = false;

    public void characterMoveAndAngle() {
        flagFire = false;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            characterCoordinate.x -= CHARACTER_MOVE_SPEED;
            updateBulletPosition();
            if (characterPosition != CHARACTER_LOOK_LEFT) {
                characterPosition = CHARACTER_LOOK_LEFT;
                fireAngle = 180 - fireAngle;
            }
            flagIncreaseFrame ++;
            if(flagIncreaseFrame == 10){
                flagIncreaseFrame = 0;
                gunnerFrameCount ++;
                gunnerFrameCount = gunnerFrameCount % 4;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            characterCoordinate.x += CHARACTER_MOVE_SPEED;
            updateBulletPosition();
            if (characterPosition != CHARACTER_LOOK_RIGHT) {
                characterPosition = CHARACTER_LOOK_RIGHT;
                fireAngle = 180 - fireAngle;
            }
            flagIncreaseFrame ++;
            if(flagIncreaseFrame == 10){
                flagIncreaseFrame = 0;
                gunnerFrameCount ++;
                gunnerFrameCount = gunnerFrameCount % 4;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if(characterPosition == CHARACTER_LOOK_LEFT){
                fireAngle -= CHARACTER_MOVE_SPEED;
            }else {
                fireAngle += CHARACTER_MOVE_SPEED;
            }
            updateBulletPosition();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if(characterPosition == CHARACTER_LOOK_LEFT){
                fireAngle += CHARACTER_MOVE_SPEED;
            }else {
                fireAngle -= CHARACTER_MOVE_SPEED;
            }
            updateBulletPosition();
        }

        if (bulletStatus == AIM) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                flagFire = true;
                flagAIM = true;
            }

            if (flagFire) {
                bulletPower += 1;
            } else if (flagAIM) {
                bulletStatus = FIRE;
                gunnerFire();
                flagAIM = false;
            }
        }
    }

    private void updateBulletPosition() {
        bulletCoordinate.x = characterCoordinate.x + characterSize.x / 2 + 80 * cosX;
        bulletCoordinate.y = characterCoordinate.y + characterSize.y / 2 + 80 * sinY;
    }

    public Vector2 getCharacterCoordinate() {
        return characterCoordinate;
    }

    public Vector2 getCharacterSize() {
        return characterSize;
    }

    public int getCharacterPosition() {
        return characterPosition;
    }

    public Vector2 getBulletCoordinate() {
        return bulletCoordinate;
    }

    public int getBulletStatus() {
        return bulletStatus;
    }

    public double getTimer() {
        return timer;
    }

    public double getFireAngle() {
        return fireAngle;
    }

    public Vector2 getBulletSize() {
        return bulletSize;
    }

    public int getGunnerFrameCount() {
        return gunnerFrameCount;
    }
}
