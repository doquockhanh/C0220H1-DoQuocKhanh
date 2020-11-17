package com.mygdx.game.Character.Extends;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Character.Player;
import com.mygdx.game.GunGame;

import java.util.ArrayList;
import java.util.List;

public class Gunner extends Player {
    private static final int AIM = 1;
    private static final int FIRE = 2;
    private static final int FIRING = 4;
    private static final int BULLET_DISPOSE = 3;
    private static final int CHARACTER_LOOK_LEFT = -45;
    private static final int CHARACTER_LOOK_RIGHT = 45;
    private static final double CHARACTER_MOVE_SPEED = 0.2;

    private Vector2 characterCoordinate;
    private Vector2 characterSize;
    private int characterPosition = CHARACTER_LOOK_LEFT;
    private int gunnerFrameCount;
    private float flagIncreaseFrame;
    private List<Texture> gunnerAnimationLeft = new ArrayList<>();
    private List<Texture> gunnerAnimationRight = new ArrayList<>();
    private GunGame game;

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

    public Gunner(GunGame game) {
        this.game = game;
        gunnerAnimationLeft.add(new Texture("gunnerLeft1.png"));
        gunnerAnimationLeft.add(new Texture("gunnerLeft2.png"));
        gunnerAnimationLeft.add(new Texture("gunnerLeft3.png"));
        gunnerAnimationLeft.add(new Texture("gunnerLeft4.png"));
        gunnerAnimationRight.add(new Texture("gunnerRight1.png"));
        gunnerAnimationRight.add(new Texture("gunnerRight2.png"));
        gunnerAnimationRight.add(new Texture("gunnerRight3.png"));
        gunnerAnimationRight.add(new Texture("gunnerRight4.png"));

        characterCoordinate = new Vector2(300, 200);
        characterSize = new Vector2(60, 60);

        bulletSize = new Vector2(15, 15);
        bulletStatus = AIM;
        bulletCoordinate = new Vector2();
        bulletCoordinate.x = characterCoordinate.x + characterSize.x / 2 + 80 * cosX;
        bulletCoordinate.y = characterCoordinate.y + characterSize.y / 2 + 80 * sinY;
        gunnerFrameCount = 0;
    }


    @Override
    public void controller() {
        if (bulletStatus != FIRING) {
            characterMoveAndAngle();
        }

        if (bulletStatus == FIRE) {
            fire();
        }
        if (bulletStatus == FIRING) {
            bulletFiring(0.0001);
        }

//      điểm xuất hiện đạn
        cosX = (float) Math.cos(-Math.PI * fireAngle / 180);
        sinY = (float) -Math.sin(-Math.PI * fireAngle / 180);
    }

    private boolean flagFire;
    private boolean flagAIM = false;
    @Override
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
            if(flagIncreaseFrame == 7){
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
            if(flagIncreaseFrame == 7){
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
                fire();
                flagAIM = false;
            }
        }

    }

    @Override
    public void updateBulletPosition() {
        bulletCoordinate.x = characterCoordinate.x + characterSize.x / 2 + 80 * cosX;
        bulletCoordinate.y = characterCoordinate.y + characterSize.y / 2 + 80 * sinY;

    }

    @Override
    public void fire() {
//      tốc độ đạn ban đầu
        bulletSpeedY = -bulletPower * 0.06 * Math.sin(Math.PI * fireAngle / 180);
        bulletSpeedX = bulletPower * 0.06 * Math.cos(Math.PI * fireAngle / 180);
        bulletStatus = FIRING;
    }

    @Override
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
            bulletPower = 0;
            game.turn ++;
            game.turn = game.turn % game.players.size();
        }
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

    public List<Texture> getGunnerAnimationLeft() {
        return gunnerAnimationLeft;
    }

    public List<Texture> getGunnerAnimationRight() {
        return gunnerAnimationRight;
    }
}
