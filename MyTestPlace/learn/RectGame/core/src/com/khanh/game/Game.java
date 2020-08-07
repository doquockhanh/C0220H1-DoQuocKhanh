package com.khanh.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.khanh.game.enemy.archer.Archer;
import com.khanh.game.enemy.knight.Knight;
import com.khanh.game.player.Player;

public class Game extends ApplicationAdapter {
    public static final int KNIGHT_COUNT = 10;
    public static final int ARCHER_COUNT = 4;
    SpriteBatch batch;
    ShapeRenderer shape;
    public static Array<Knight> knights;
    public static Array<Archer> archers;
    public static com.khanh.game.player.Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        player = new Player();
        knights = new Array<>();
        archers = new Array<>();
        for (int i = 0; i < KNIGHT_COUNT; i++) {
            knights.add(new Knight((float) Math.random() * (Gdx.graphics.getWidth())));
        }
        for (int i = 0; i < ARCHER_COUNT; i++) {
            archers.add(new Archer());
        }
    }

    public void update() {
        player.update();
        for (int i = 0; i < KNIGHT_COUNT; i++) {
            knights.get(i).update();
        }
        for (int i = 0; i < ARCHER_COUNT; i++) {
            archers.get(i).update();
        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.setAutoShapeType(true);
        shape.begin();
        shape.setColor(Color.RED);
        shape.ellipse(player.getPosition().x, player.getPosition().y, player.getSize(), player.getSize());
        for (Knight knight : knights) {
            shape.setColor(Color.GREEN);
            shape.ellipse(knight.getPosition().x, knight.getPosition().y, knight.getSize(), knight.getSize());
        }
        for (Archer archer : archers) {
            shape.setColor(Color.YELLOW);
            shape.ellipse(archer.getPosition().x, archer.getPosition().y, archer.getSize(), archer.getSize());
        }
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
        batch.dispose();
    }
}
