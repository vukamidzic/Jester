package com.jester.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.jester.game.Jester;

public class DesktopLauncher {
	static int WINDOW_WIDTH = 1920;
	static int WINDOW_HEIGHT = 1080;
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
		config.setForegroundFPS(60);
		config.setTitle("Jester");
		new Lwjgl3Application(new Jester(), config);
	}
}
