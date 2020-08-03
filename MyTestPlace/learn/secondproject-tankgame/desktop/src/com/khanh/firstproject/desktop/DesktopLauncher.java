package com.khanh.firstproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.khanh.firstproject.tankgame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = tankgame.GAME_HEIGHT;
		config.width = tankgame.GAME_WIDTH;
		new LwjglApplication(new tankgame(), config);
	}
}