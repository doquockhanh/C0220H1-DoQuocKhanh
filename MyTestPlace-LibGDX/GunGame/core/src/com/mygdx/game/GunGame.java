package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Character.Gunner;

import java.util.ArrayList;
import java.util.List;

public class GunGame extends ApplicationAdapter {
	private static final int GUNNER_NUMBER_OF_FRAME = 4;

	SpriteBatch batch;
	Texture gunnerBullet;
	ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private Gunner gunner;
	private List<Texture> gunnerRightAnimation = new ArrayList<>();
	private List<Texture> gunnerLeftAnimation = new ArrayList<>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		gunnerRightAnimation.add(new Texture("gunnerRight1.png"));
		gunnerRightAnimation.add(new Texture("gunnerRight2.png"));
		gunnerRightAnimation.add(new Texture("gunnerRight3.png"));
		gunnerRightAnimation.add(new Texture("gunnerRight4.png"));
		gunnerLeftAnimation.add(new Texture("gunnerLeft1.png"));
		gunnerLeftAnimation.add(new Texture("gunnerLeft2.png"));
		gunnerLeftAnimation.add(new Texture("gunnerLeft3.png"));
		gunnerLeftAnimation.add(new Texture("gunnerLeft4.png"));
		gunnerBullet = new Texture("gunnerBullet.png");
		shapeRenderer = new ShapeRenderer();
		gunner = new Gunner();
	}

//	main loop
	@Override
	public void render () {
//		render ra nhan vat
        drawGunner();
        processing();
	}

	//	controller
	public void processing(){
		gunner.gunnerController();
	}

	public void drawGunner(){
		Gdx.gl.glClearColor(0.1f, 0.2f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		vẽ gunner
		batch.begin();
		if(gunner.getCharacterPosition() == -45){
			batch.draw(gunnerLeftAnimation.get(gunner.getGunnerFrameCount()), gunner.getCharacterCoordinate().x, gunner.getCharacterCoordinate().y, gunner.getCharacterSize().x , gunner.getCharacterSize().y);
		}else {
			batch.draw(gunnerRightAnimation.get(gunner.getGunnerFrameCount()), gunner.getCharacterCoordinate().x, gunner.getCharacterCoordinate().y,gunner.getCharacterSize().x , gunner.getCharacterSize().y);
		}

		if(gunner.getBulletStatus() == 4){
			batch.draw(gunnerBullet, gunner.getBulletCoordinate().x, gunner.getBulletCoordinate().y, gunner.getBulletSize().x, gunner.getBulletSize().y);
		}
		batch.end();

//      ve sung gunner
		shapeRenderer.setAutoShapeType(true);
		shapeRenderer.begin();

		float cosX = (float) Math.cos(-Math.PI * gunner.getFireAngle() / 180);
		float sinY = (float) - Math.sin(-Math.PI * gunner.getFireAngle() / 180);

		shapeRenderer.rectLine(
				gunner.getCharacterCoordinate().x + gunner.getCharacterSize().x/2,
				gunner.getCharacterCoordinate().y + gunner.getCharacterSize().y/2,
				gunner.getCharacterCoordinate().x + gunner.getCharacterSize().x/2 + 80 * cosX + gunner.getBulletSize().x / 2,
				gunner.getCharacterCoordinate().y + gunner.getCharacterSize().y/2 + 80 * sinY + gunner.getBulletSize().y / 2,
				10
				);

		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gunnerBullet.dispose();
		shapeRenderer.dispose();
	}
}
