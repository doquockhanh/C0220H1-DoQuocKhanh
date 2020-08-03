package com.khanh.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class RectGame extends ApplicationAdapter {
	public static final int BOMB_COUNT = 10;
	SpriteBatch batch;
	Texture img;
	ShapeRenderer shape;
	public static Array<Bomb> bombs;
	public static Human human;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		human = new Human();
		bombs = new Array<>();
		for (int i = 0; i < BOMB_COUNT; i++) {
			bombs.add(new Bomb((float) Math.random()*(Gdx.graphics.getWidth())));
		}
	}

	public void update(){
		for (int i = 0; i < BOMB_COUNT; i++) {
			bombs.get(i).update();
		}
		human.update();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.setAutoShapeType(true);
		shape.begin();
		shape.setColor(Color.RED);
		shape.ellipse(human.getPosition().x, human.getPosition().y, human.getSize(), human.getSize());
		for (Bomb bomb: bombs) { shape.setColor(Color.GREEN);
           shape.ellipse(bomb.getPosition().x, bomb.getPosition().y, bomb.getSize(), bomb.getSize());
		}
		shape.end();
	}
	
	@Override
	public void dispose () {
		shape.dispose();
		batch.dispose();
		img.dispose();
	}
}
