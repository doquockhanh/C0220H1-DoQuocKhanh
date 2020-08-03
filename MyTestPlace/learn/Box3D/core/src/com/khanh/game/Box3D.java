package com.khanh.game;

import com.badlogic.gdx.Game;


public class Box3D extends Game {

	GameScreen gameScreen;

	@Override
	public void create() {
        gameScreen = new GameScreen();
        setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		gameScreen.dispose();
	}

	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}

	@Override
	public void render() {
		super.render();
	}
}
