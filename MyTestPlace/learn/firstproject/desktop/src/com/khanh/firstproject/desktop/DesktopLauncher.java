package com.khanh.firstproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.khanh.firstproject.firstproject;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = firstproject.WIDTH;
		config.height = firstproject.HEIGHT;
		config.title = firstproject.TITLE;
		new LwjglApplication(new firstproject(), config);
	}
}