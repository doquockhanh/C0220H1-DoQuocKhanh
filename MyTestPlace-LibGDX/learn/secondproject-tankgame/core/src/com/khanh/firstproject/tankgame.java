package com.khanh.firstproject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import jdk.internal.jline.internal.ShutdownHooks;

import java.util.TimerTask;

public class tankgame extends ApplicationAdapter {
    public static final int GAME_WIDTH = 1500;
    public static final int GAME_HEIGHT = 900;
    private static final int TANK_WIDTH = 100;
    private static final int TANK_HEIGHT = 100;
    private static final int TANK_SPEED = 8;

    private SpriteBatch spriteBatch;
    public static Vector2 tankPosition = new Vector2(800, 400);
    private Texture tank;
    private Texture bullet;
    private Bullet cannon1;
    private Bullet cannon2;
    private Bullet cannon3;
    private Bullet cannon4;
    private Rectangle recTank;
    private Color color;
    private ShapeRenderer shapeRenderer;

    public void create() {
        spriteBatch = new SpriteBatch();
        tank = new Texture("tank.png");
        bullet = new Texture("bullet.png");
        cannonFire();
        cannon1 = new Bullet();
        cannon2 = new Bullet();
        cannon3 = new Bullet();
        cannon4 = new Bullet();
        recTank = new Rectangle(tankPosition.x, tankPosition.y, TANK_WIDTH / 2, TANK_HEIGHT / 2);
    }

    private void cannonFire() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                cannon1 = new Bullet(0, 0, 1);
                cannon1.cannon1Fire();
                cannon2 = new Bullet(0, 900, 2);
                cannon2.cannon2Fire();
                cannon3 = new Bullet(1500, 0, 3);
                cannon3.cannon3Fire();
                cannon4 = new Bullet(1500, 900, 4);
                cannon4.cannon4Fire();
                cannonFire();
            }
        }, 3);
    }

    public void tankMove() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tankPosition.x > 0) {
            tankPosition.x -= TANK_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tankPosition.x < GAME_WIDTH - TANK_WIDTH) {
            tankPosition.x += TANK_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && tankPosition.y < GAME_HEIGHT - TANK_HEIGHT) {
            tankPosition.y += TANK_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && tankPosition.y > 0) {
            tankPosition.y -= TANK_SPEED;
        }
        recTank.setPosition(tankPosition.x, tankPosition.y);
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(tank, tankPosition.x, tankPosition.y, TANK_WIDTH, TANK_HEIGHT);
        if (cannon1.exist()) {
            spriteBatch.draw(bullet, cannon1.getPosition().x, cannon1.getPosition().y, Bullet.BULLET_SIZE, Bullet.BULLET_SIZE);
        }
        if (cannon2.exist()) {
            spriteBatch.draw(bullet, cannon2.getPosition().x, cannon2.getPosition().y, Bullet.BULLET_SIZE, Bullet.BULLET_SIZE);
        }
        if (cannon3.exist()) {
            spriteBatch.draw(bullet, cannon3.getPosition().x, cannon3.getPosition().y, Bullet.BULLET_SIZE, Bullet.BULLET_SIZE);
        }
        if (cannon4.exist()) {
            spriteBatch.draw(bullet, cannon4.getPosition().x, cannon4.getPosition().y, Bullet.BULLET_SIZE, Bullet.BULLET_SIZE);
        }
        spriteBatch.end();
        tankMove();
    }

    public void dispose() {

    }
}

